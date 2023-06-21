package repository.impl;

import base.repository.BaseRepository;
import base.repository.impl.BaseRepositoryImpl;
import entity.Book;
import entity.Issue;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import repository.BookRepository;
import util.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book,Long> implements BookRepository {
    private Session session = HibernateUtil.getSessionfactory().openSession();
    public BookRepositoryImpl(Session session) {
        super(session);
    }

    @Override
    public Class<Book> getEntityClass() {
        return Book.class;
    }


    @Override
    public Optional<Book> searchByBook(Book book) {
        Book ans =session.createQuery("from Book where name=:name and author=:author and dateOfPrint=:date",
                Book.class).setParameter("name",book.getName()).setParameter("author",book.getAuthor())
                .setParameter("date",book.getDateOfPrint()).getSingleResult();
        return Optional.ofNullable(ans);
    }
    @Override
    public List<Book> booksNotHaveIssue(){
        List<Book> ans= session.createQuery("from Book b where not exists (from Issue where book.id=b.id)",
                Book.class).getResultList();
                return ans;
    }
    public String searchWithIssue(String issue){
        try {
            List<Issue> books = session.createQuery("from Issue where issue=:issue",
                    Issue.class).setParameter("issue",issue).getResultList();
            if (books != null){
            for (Issue b:books
                 ) {
                System.out.println("id :"+b.getId());
                System.out.println("name :"+b.getBook().getName());
                System.out.println("author :"+b.getBook().getAuthor());
                System.out.println("date of print :"+b.getBook().getDateOfPrint());
                System.out.println("=====================================");
                }
            }else {
                System.out.println("we dont have any book with this issue");
            }
        }catch (NoResultException e){
            System.out.println("we dont have any book with this issue");
        }
        return "";
    }
}
