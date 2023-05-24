package org.example.base.repository;

import org.example.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseRepository<T extends BaseEntity<U>,U extends Serializable> {
    T save(T entity);
    T update(T entity);
    Optional<T> loadById(U id);
    List<T> loadAll();
    void remove(T entity);

}
