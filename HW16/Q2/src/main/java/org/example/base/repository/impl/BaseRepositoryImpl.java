package org.example.base.repository.impl;

import org.example.base.entity.BaseEntity;
import org.example.base.repository.BaseRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl <T extends BaseEntity<U>, U extends Serializable>
                                            implements BaseRepository<T ,U> {
    StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
    public SessionFactory factory = meta.getSessionFactoryBuilder().build();
    public Session session = factory.openSession();
    @Override
    public T save(T entity) {
        if (entity.getId() == null) {
            session.persist(entity);
            return entity;
        }
        return null;
    }

    @Override
    public T update(T entity) {
        if (entity.getId() != null) {
            session.merge(entity);
            return entity;
        }
        return null;
    }

   @Override
    public Optional<T> loadById(U id) {

        return Optional.ofNullable(session.find(getEntityClass(), id));

    }

    @Override
    public List<T> loadAll() {
        // select from table name,type of output
        return session.createQuery(" FROM  " + getEntityClass().getSimpleName(), getEntityClass()).getResultList();
    }

    @Override
    public void remove(T entity) {
        if (entity.getId() != null) {
            session.remove(entity);
        }
        else System.out.println("this entity is not found");
    }

    public abstract Class<T> getEntityClass();

}
