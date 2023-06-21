import org.hibernate.Hibernate;
import org.hibernate.Session;
import repository.BookRepository;
import repository.IssueRepository;
import repository.MemberRepository;
import repository.impl.BookRepositoryImpl;
import repository.impl.IssueRepositoryImpl;
import repository.impl.MemberRepositoryImpl;
import util.HibernateUtil;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionfactory().openSession();

//        Long a;
//        a = Math.round(Math.random()*100000);
//        System.out.println(a);

        BookRepository bookRepository = new BookRepositoryImpl(session);
        IssueRepository issueRepository = new IssueRepositoryImpl(session);
        System.out.println(issueRepository.showIssue());
        MemberRepository memberRepository = new MemberRepositoryImpl(session);


    }
}
