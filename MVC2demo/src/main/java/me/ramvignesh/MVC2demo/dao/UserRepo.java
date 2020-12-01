package me.ramvignesh.MVC2demo.dao;

import org.springframework.data.repository.CrudRepository;

import me.ramvignesh.MVC2demo.model.UserModel;

public interface UserRepo extends CrudRepository<UserModel, Integer> {

	UserModel findByUsername(String username);
}
