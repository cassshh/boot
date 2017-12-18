package com.casheep.service;

import com.casheep.model.User;
import com.casheep.persistance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createData() {
        userRepository.save(new User("Bakker", "jbakker@gmail"));
        userRepository.save(new User("Molenaar", "wmolenaar@gmail"));
        userRepository.save(new User("Kerstens", "kkerstens@yahoo"));
        userRepository.save(new User("Bakker", "hbakker@live"));
    }

    @Override
    public List<User> getUserByName(String name) {
        return userRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
