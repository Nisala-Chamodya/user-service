package com.zoory.userservice.service;

import com.zoory.userservice.dto.UserRequestDTO;
import com.zoory.userservice.dto.UserResponseDTO;
import com.zoory.userservice.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserRequestDTO userRequestDTO);
    User  updateUser(String id,UserRequestDTO userRequestDTO);
    User  deleteUser(String id);

    List<User>getAllUsers();
}
