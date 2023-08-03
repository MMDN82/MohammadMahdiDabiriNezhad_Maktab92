package base.service.impl;

import base.entity.BaseEntity;
import base.repository.BaseRepository;
import base.service.BaseService;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<E extends BaseEntity<ID>,ID extends Serializable,
        REPOSITORY extends BaseRepository<E,ID>> implements BaseService<E,ID> {
        protected REPOSITORY repository;
    public BaseServiceImpl(REPOSITORY repository) {
        this.repository = repository;
    }
    @Override
    public E save(E entity) {
        repository.getSession().getTransaction().begin();
        repository.save(entity);
        repository.getSession().getTransaction().commit();
        return entity;
    }
    @Override
    public E update(E entity) {
        repository.getSession().getTransaction().begin();
        repository.update(entity);
        repository.getSession().getTransaction().commit();
        return entity;
    }
    @Override
    public Optional<E> findById(ID id) {
        return repository.findById(id);
    }
    @Override
    public List<E> findAll() {
        return repository.findAll();
    }
    @Override
    public void delete(E entity) {
        repository.getSession().getTransaction().begin();
        repository.delete(entity);
        repository.getSession().getTransaction().commit();
    }
}
