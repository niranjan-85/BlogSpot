package com.blogSpot.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogSpot.backend.Payloads.UserDto;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Integer user_Id);

    UserDto updateUserPassword(String newPassword, Integer user_Id);

    UserDto getUserById(Integer user_Id);

    List<UserDto> getAllUsers();

    void deleteUser(Integer user_Id);

}
