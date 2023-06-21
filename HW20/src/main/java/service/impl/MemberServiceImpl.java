package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Member;
import org.hibernate.Session;
import repository.MemberRepository;
import repository.impl.MemberRepositoryImpl;
import service.MemberService;
import util.HibernateUtil;

import java.util.Optional;

public class MemberServiceImpl extends BaseServiceImpl<Member, Long> implements MemberService {
    public MemberServiceImpl(Session session) {
        super(session);
    }
    private Session session = HibernateUtil.getSessionfactory().openSession();
    private MemberRepository memberRepository=new MemberRepositoryImpl(session);

    @Override
    public Class<Member> getEntityClass() {
        return Member.class;
    }


}
