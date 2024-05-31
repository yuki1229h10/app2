package com.example.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.app.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
