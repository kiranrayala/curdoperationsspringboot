package com.kiran.firstproject.CurdOperations;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kiran.firstproject.CurdOperations.model.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
}
