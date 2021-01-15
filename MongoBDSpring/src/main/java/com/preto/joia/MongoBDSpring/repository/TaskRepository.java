package com.preto.joia.MongoBDSpring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.preto.joia.MongoBDSpring.entity.Task;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {

}
