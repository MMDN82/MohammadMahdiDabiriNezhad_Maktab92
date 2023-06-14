package Base.repository.impl;

import Base.entity.BaseEntity;
import Base.repository.BaseRepository;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>,ID extends Serializable>
                                implements BaseRepository<E,ID> {

    private Session session;
    public abstract Class<E> getEntityClass();

    public BaseRepositoryImpl(Session session) {
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
    public Optional<E> findById(ID id) {
        E ans = session.find(getEntityClass(),id);
        return Optional.ofNullable(ans);
    }

    @Override
    public List<E> findAll() {
        List<E> ans;
        ans = session.createQuery("from "+getEntityClass().getSimpleName(),
                getEntityClass()).getResultList();
        return ans;
    }

    @Override
    public void delete(E entity) {
        session.getTransaction().begin();
        session.remove(entity);
        session.getTransaction().commit();
    }
}
