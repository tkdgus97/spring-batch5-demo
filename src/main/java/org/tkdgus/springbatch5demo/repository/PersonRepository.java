package org.tkdgus.springbatch5demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tkdgus.springbatch5demo.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
