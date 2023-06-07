package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Comment;
import entity.Users;
import org.hibernate.Session;
import repository.CommentRepository;
import utill.HibernateUtil;

import java.util.List;

public class CommentRepositoryImpl extends BaseRepositoryImpl<Comment,Long> implements CommentRepository {
    public CommentRepositoryImpl(Session session) {
        super(session);
    }
    @Override
    public Class<Comment> getEntityClass() {
        return Comment.class;
    }
    Session session = HibernateUtil.getSessionFactory().openSession();
    @Override
    public List<Comment> yourComments(Users user) {

        List<Comment> comments = session.createQuery("from Comment where users=:user",
                Comment.class).setParameter("user",user).getResultList();

        return comments;
    }
}
