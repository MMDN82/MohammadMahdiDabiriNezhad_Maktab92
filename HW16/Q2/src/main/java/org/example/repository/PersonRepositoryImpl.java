package org.example.repository;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.entity.Person;

public class PersonRepositoryImpl extends BaseRepositoryImpl <Person , Long>{
    @Override
    public Class<Person> getEntityClass() {
        return Person.class;
    }
}
