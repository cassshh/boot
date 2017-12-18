package com.casheep.service;

import com.casheep.model.User;

import java.util.List;

public interface UserService {

    void createData();

    List<User> getUserByName(String name);

    User getUserByEmail(String email);

}
