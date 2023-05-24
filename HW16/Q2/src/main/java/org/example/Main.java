package org.example;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.entity.Person;
import org.example.repository.PersonRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("ma", "asd", LocalDate.of(1999, 12, 12));
        PersonRepositoryImpl personRepository = new PersonRepositoryImpl();
        personRepository.save(person);
    }
}
