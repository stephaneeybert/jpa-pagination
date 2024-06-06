package com.thalasoft.java.data.jpa.pagination.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.thalasoft.java.data.jpa.pagination.model.Person;

public interface PersonRepository extends PagingAndSortingRepository<Person, Integer>, CrudRepository<Person, Integer> {
}
