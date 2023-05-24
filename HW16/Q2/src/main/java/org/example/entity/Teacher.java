package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
    public class Teacher extends Person{
        @Column(nullable = false)
        private int masterCode;
        private String degreeOfEducation;
        private enum MastersDegree{master , professor , fullProfessor};
        private long salary;
    }

