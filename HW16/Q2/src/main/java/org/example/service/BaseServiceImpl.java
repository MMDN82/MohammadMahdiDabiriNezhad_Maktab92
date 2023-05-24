package org.example.service;

import org.example.base.entity.BaseEntity;
import org.example.base.repository.BaseRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class BaseServiceImpl <T extends BaseEntity<U>,U extends Serializable , R extends BaseRepository<T , U>>
        implements BaseRepository<T ,U>  {
    protected  final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(T entity) {
        return repository.update(entity);
    }

    @Override
    public Optional<T> loadById(U id) {
        return repository.loadById(id);
    }

    @Override
    public List<T> loadAll() {
        return repository.loadAll();
    }

    @Override
    public void remove(T entity) {
        repository.remove(entity);
    }

    public void signUo(){
        
    }

}

