package menu;

import entity.Book;
import entity.Issue;
import entity.Librarian;
import entity.Member;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import repository.BookRepository;
import repository.IssueRepository;
import repository.MemberRepository;
import repository.impl.BookRepositoryImpl;
import repository.impl.IssueRepositoryImpl;
import repository.impl.MemberRepositoryImpl;
import service.BookService;
import service.MemberService;
import service.impl.BookServiceImpl;
import service.impl.MemberServiceImpl;
import util.HibernateUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionfactory().openSession();
        Librarian librarian = new Librarian();
        Member member = new Member();
        BookService bookService = new BookServiceImpl(session);
        BookRepository bookRepository = new BookRepositoryImpl(session);
        IssueRepository issueRepository = new IssueRepositoryImpl(session);
        MemberRepository memberRepository = new MemberRepositoryImpl(session);
        int num;
        Long num1;
        Long num2;
        String value;

        while (true){
            System.out.println("Enter number : ");
            System.out.println("1-member");
            System.out.println("2-librarian");
            num = new Scanner(System.in).nextInt();
            switch (num){

                case 1:
                    while (true){
                        System.out.println("1-login");
                        System.out.println("2-sign up");
                        System.out.println("3-back");
                        num=new Scanner(System.in).nextInt();
                        switch (num){
                            case 1:
                                System.out.println("Enter membershipCode : ");
                                num1=new Scanner(System.in).nextLong();
                                System.out.println("Enter nationalCode : ");
                                num2 = new Scanner(System.in).nextLong();
                                try {
                                    member = session.createQuery("from Member m where m.membershipCode=:membershipCode and m.nationalCode=:nationalCode",
                                            Member.class).setParameter("membershipCode", num1).setParameter("nationalCode", num2).getSingleResult();
                                } catch (NoResultException e) {
                                    System.out.println("membershipCode or nationalCode is incorrect");
                                    break;
                                }
                                if (member != null){
                                    while (true){
                                        System.out.println("1-account");
                                        System.out.println("2-books");
                                        System.out.println("3-view issues");
                                        System.out.println("4-issues from a book");
                                        System.out.println("5-search book with issue");
                                        System.out.println("10-logout");
                                        num=new Scanner(System.in).nextInt();
                                        switch (num){
                                            case 1:
                                                System.out.println("firstname : "+ member.getFirstname());
                                                System.out.println("lastname : "+ member.getLastname());
                                                System.out.println("date of birth : "+ member.getDateOfBirth());
                                                System.out.println("national code : "+ member.getNationalCode());
                                                System.out.println("membership code : "+ member.getMembershipCode());
                                                break;
                                            case 2:
                                                List<Book> books =bookRepository.findAll();
                                                for (Book b:books
                                                     ) {
                                                    System.out.println("id : "+b.getId());
                                                    System.out.println("name : "+b.getName());
                                                    System.out.println("author : "+b.getAuthor());
                                                    System.out.println("date of print : "+b.getDateOfPrint());
                                                    System.out.println("===================================");
                                                }
                                                break;
                                            case 3:
                                                System.out.println(issueRepository.showIssue());
                                                break;
                                            case 4:
                                                System.out.println("enter id of book : ");
                                                num1 = new Scanner(System.in).nextLong();
                                                issueRepository.IssueByBookId(num1);
                                                System.out.println();
                                                break;
                                            case 5:
                                                System.out.println("enter issue : ");
                                                value = new Scanner(System.in).nextLine();
                                                bookRepository.searchWithIssue(value);
                                                break;
                                        }
                                        if (num==10){
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 2:
                                 member = new Member();
                                System.out.println("enter your name : ");
                                value=new Scanner(System.in).nextLine();
                                member.setFirstname(value);
                                System.out.println("enter your lastname : ");
                                value=new Scanner(System.in).nextLine();
                                member.setLastname(value);
                                System.out.println("enter date of birth [yyyy.MM.dd] : ");
                                value = new Scanner(System.in).next();
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
                                LocalDate localDate = LocalDate.parse(value, dtf);
                                member.setDateOfBirth(localDate);
                                System.out.println("enter your national code : ");
                                num1=new Scanner(System.in).nextLong();
                                member.setNationalCode(num1);
                                memberRepository.SignUp(member);
                                break;
                        }
                        if (num==3){
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter EmployeeCode : ");
                    num1=new Scanner(System.in).nextLong();
                    System.out.println("Enter nationalCode : ");
                    num2 = new Scanner(System.in).nextLong();
                    try {
                        librarian = session.createQuery("from Librarian where EmployeeCode=:employeeCode and nationalCode=:nationalCode",
                                Librarian.class).setParameter("employeeCode", num1).setParameter("nationalCode", num2).getSingleResult();
                    } catch (NoResultException e) {
                        System.out.println("EmployeeCode or nationalCode is incorrect");
                        break;
                    }
                    if (librarian != null){
                        while (true){
                            System.out.println("1-Book and issue");
                            System.out.println("2-member");
                            System.out.println("3-logout");
                            num = new Scanner(System.in).nextInt();
                            switch (num){
                                case 1:
                                    while (true) {
                                        System.out.println("1-view books");
                                        System.out.println("2-add books");
                                        System.out.println("3-edite book");
                                        System.out.println("4-remove book");
                                        System.out.println("5-Books that do not have a issue");
                                        System.out.println("6-add issue");
                                        System.out.println("7-issues from a book");
                                        System.out.println("8-edite issue");
                                        System.out.println("9-delete issue");
                                        System.out.println("10-all issue");
                                        System.out.println("11-back");
                                        num = new Scanner(System.in).nextInt();
                                        switch (num){
                                            case 1:
                                                System.out.println(bookRepository.findAll());
                                                break;
                                            case 2:
                                                Book book = new Book();
                                                System.out.println("enter name : ");
                                                value = new Scanner(System.in).nextLine();
                                                book.setName(value);
                                                System.out.println("enter author : ");
                                                value = new Scanner(System.in).next();
                                                book.setAuthor(value);
                                                System.out.println("enter date of print [yyyy.MM.dd] : ");
                                                value = new Scanner(System.in).next();
                                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
                                                LocalDate localDate = LocalDate.parse(value, dtf);
                                                book.setDateOfPrint(localDate);
                                                System.out.println("enter inventory : ");
                                                num1 = new Scanner(System.in).nextLong();
                                                book.setInventory(num1);
                                                try {
                                                    if (bookRepository.searchByBook(book).isPresent()){
                                                        System.out.println("this book is exist you must edite this");
                                                    }
                                                }catch (NoResultException e){
                                                    bookRepository.save(book);
                                                }
                                                break;
                                            case 3:
                                                while (true){
                                                    System.out.println("1-edite name of book");
                                                    System.out.println("2-edite author of book");
                                                    System.out.println("3-edite date of print of book");
                                                    System.out.println("4-edite inventory of book");
                                                    System.out.println("5-back");
                                                    num=new Scanner(System.in).nextInt();
                                                    switch (num){
                                                        case 1:
                                                            System.out.println("enter id of book : ");
                                                            num1=new Scanner(System.in).nextLong();
                                                            Optional<Book> en =bookRepository.findById(num1);
                                                            if ( en .isPresent()){
                                                                System.out.println("enter new name : ");
                                                                value=new Scanner(System.in).nextLine();
                                                                 en .get().setName(value);
                                                                bookRepository.update( en .get());
                                                            }
                                                            else {
                                                                System.out.println("this id not exist");
                                                            }
                                                            break;
                                                        case 2:
                                                            System.out.println("enter id of book : ");
                                                            num1=new Scanner(System.in).nextLong();
                                                            Optional<Book> ea =bookRepository.findById(num1);
                                                            if ( ea .isPresent()){
                                                                System.out.println("enter new author : ");
                                                                value=new Scanner(System.in).nextLine();
                                                                ea.get().setAuthor(value);
                                                                bookRepository.update( ea .get());
                                                            }
                                                            else {
                                                                System.out.println("this id not exist");
                                                            }
                                                            break;
                                                        case 3:
                                                            System.out.println("enter id of book : ");
                                                            num1=new Scanner(System.in).nextLong();
                                                            Optional<Book> ed =bookRepository.findById(num1);
                                                            if (ed.isPresent()){
                                                                System.out.println("enter new date of print [yyyy.MM.dd] : ");
                                                                value = new Scanner(System.in).next();
                                                                DateTimeFormatter ndtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
                                                                LocalDate nlocalDate = LocalDate.parse(value, ndtf);
                                                                ed.get().setDateOfPrint(nlocalDate);
                                                                bookRepository.update(ed.get());
                                                            }else {
                                                                System.out.println("this id not exist");
                                                            }
                                                            break;
                                                        case 4:
                                                            System.out.println("enter id of book : ");
                                                            num1=new Scanner(System.in).nextLong();
                                                            Optional<Book> ei =bookRepository.findById(num1);
                                                            if (ei.isPresent()){
                                                                System.out.println("enter new inventory : ");
                                                                num1 = new Scanner(System.in).nextLong();
                                                                ei.get().setInventory(num1);
                                                                bookRepository.update(ei.get());
                                                            }else {
                                                                System.out.println("this id not exist");
                                                            }
                                                            break;
                                                    }
                                                    if (num==5){
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 4:
                                                System.out.println("enter id of book : ");
                                                num1=new Scanner(System.in).nextLong();
                                                Optional<Book> db = bookRepository.findById(num1);
                                                if (db.isPresent()){
                                                    bookRepository.remove(db.get());
                                                }else {
                                                    System.out.println("this id not exist");
                                                }
                                                break;
                                            case 5:
                                                System.out.println(bookRepository.booksNotHaveIssue());
                                                break;
                                            case 6:
                                                Issue issue = new Issue();
                                                System.out.println("enter id of book : ");
                                                num1=new Scanner(System.in).nextLong();
                                                Optional<Book> ai = bookRepository.findById(num1);
                                                if (ai.isPresent()){
                                                System.out.println("enter issue : ");
                                                value = new Scanner(System.in).nextLine();
                                                issue.setIssue(value);
                                                issue.setBook(ai.get());
                                                issueRepository.save(issue);
                                                }else {
                                                    System.out.println("this id not exist");
                                                }
                                                break;
                                            case 7:
                                                System.out.println("enter id of book : ");
                                                num1 = new Scanner(System.in).nextLong();
                                                    issueRepository.IssueByBookId(num1);
                                                    System.out.println();
                                                break;
                                            case 8:
                                                System.out.println("enter issue id : ");
                                                num1=new Scanner(System.in).nextLong();
                                                Optional<Issue> ei = issueRepository.findById(num1);
                                                if (ei.isPresent()){
                                                    System.out.println("enter new issue");
                                                    value=new Scanner(System.in).nextLine();
                                                    ei.get().setIssue(value);
                                                    issueRepository.update(ei.get());
                                                }else {
                                                    System.out.println("this issue not exist");
                                                }
                                                break;
                                            case 9:
                                                System.out.println("enter issue id : ");
                                                num1=new Scanner(System.in).nextLong();
                                                Optional<Issue> di = issueRepository.findById(num1);
                                                if (di.isPresent()){
                                                    issueRepository.remove(di.get());
                                                }else {
                                                    System.out.println("this issue not exist");
                                                }
                                                break;
                                            case 10:
                                                System.out.println(issueRepository.showIssue());
                                                break;
                                        }
                                        if (num==11){
                                            break;
                                        }
                                    }
                                case 2:

                                    break;
                            }
                            if (num==3){
                                break;
                            }
                        }
                    }



                    break;

            }



        }
    }
}
