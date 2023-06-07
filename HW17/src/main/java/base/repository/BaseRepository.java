package base.repository;

import base.entity.BaseEntity;

import javax.swing.text.html.parser.Entity;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseRepository <E extends BaseEntity<ID> , ID extends Serializable>{
    E save(E entity);
    E update(E entity);
    Optional<E> findById(ID id);
    List<E> findAll();
    void delete(E entity);
}
