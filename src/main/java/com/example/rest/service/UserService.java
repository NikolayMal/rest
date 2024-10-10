package com.example.rest.service;

import com.example.rest.dto.UserDTO;
import com.example.rest.model.User;

import java.util.List;

public interface UserService {

//    List<UserDTO> getAllUsers();

    User getById(Long id);

    List<User> getAll();

    User save(User user);
}
