package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Book;
import entity.Issue;
import org.hibernate.Session;
import repository.BookRepository;
import repository.IssueRepository;
import util.HibernateUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class IssueRepositoryImpl extends BaseRepositoryImpl<Issue,Long> implements IssueRepository {
    private  Session session = HibernateUtil.getSessionfactory().openSession();
    BookRepository bookRepository = new BookRepositoryImpl(session);
    public IssueRepositoryImpl(Session session) {
        super(session);
    }

    @Override
    public Class<Issue> getEntityClass() {
        return Issue.class;
    }
    @Override
    public String IssueByBookId(Long id){
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()){
        List<Issue> ans = session.createQuery("from Issue where book.id=:id",
                Issue.class).setParameter("id",id).getResultList();
        for (Issue s:ans
             ) {
            System.out.println(s.getId() + "_" + s.getIssue() + ":" + s.getBook());
            }
        }else {
            System.out.println("this book not exist or not have issue");
        }
                return "";
    }
    @Override
    public List<String> showIssue(){
        List<String> ans=session.createQuery("select issue from Issue ",
                String.class).getResultList();
        Set<String> set=new HashSet<>(ans);
        ans.clear();
        ans.addAll(set);
        return ans;
    }
}
