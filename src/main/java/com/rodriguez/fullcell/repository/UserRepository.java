package com.rodriguez.fullcell.repository;

import org.springframework.data.repository.CrudRepository;

import com.rodriguez.fullcell.model.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Integer>{

}
