package base.service.impl;

import base.entity.BaseEntity;
import base.repository.BaseRepository;
import base.repository.impl.BaseRepositoryImpl;
import base.service.BaseService;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends BaseEntity<ID>,ID extends Serializable> implements BaseService<E,ID> {
    private Session session;
    public abstract Class<E> getEntityClass();

    public BaseServiceImpl(Session session) {
        this.session = session;
    }

    @Override
    public E save(E entity) {
        session.getTransaction().begin();
        session.persist(entity);
        session.getTransaction().commit();
        return entity;
    }

    @Override
    public E update(E entity) {
        session.getTransaction().begin();
        session.merge(entity);
        session.getTransaction().commit();
        return entity;
    }

    @Override
    public void remove(E entity) {
        session.getTransaction().begin();
        session.remove(entity);
        session.getTransaction().commit();
    }

    @Override
    public Optional<E> findById(ID id) {
        E ans = session.find(getEntityClass(),id);
        return Optional.ofNullable(ans);
    }

    @Override
    public List<E> findAll() {
        List<E> ans = session.createQuery("from "+getEntityClass().getSimpleName(),
                getEntityClass()).getResultList();
        return ans;
    }
}
