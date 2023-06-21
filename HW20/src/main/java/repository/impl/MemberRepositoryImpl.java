package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Member;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import repository.MemberRepository;
import util.HibernateUtil;

import java.util.Optional;

public class MemberRepositoryImpl extends BaseRepositoryImpl<Member,Long> implements MemberRepository {
    private Session session= HibernateUtil.getSessionfactory().openSession();
    public MemberRepositoryImpl(Session session) {
        super(session);
    }

    @Override
    public Class<Member> getEntityClass() {
        return Member.class;
    }

    @Override
    public String SignUp(Member member) {

        try {
            Member m = session.createQuery("from Member  m where m.nationalCode=:na",
                    Member.class).setParameter("na", member.getNationalCode()).getSingleResult();
                System.out.println("This profile is available, you must login");
        }catch (NoResultException e){
            Long code = Math.round(Math.random()*100000);
            member.setMembershipCode(code);
            save(member);
            System.out.println("welcome");
                System.out.println("your membershipCode is : "+code);
        }

        return "";
    }
}
