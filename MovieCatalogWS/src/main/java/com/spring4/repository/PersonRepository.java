package com.spring4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring4.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
