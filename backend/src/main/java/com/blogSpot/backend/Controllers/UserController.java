package com.blogSpot.backend.Controllers;

import com.blogSpot.backend.Payloads.UserPasswordDto;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blogSpot.backend.Payloads.UserDto;
import com.blogSpot.backend.Services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        UserDto createdUser = service.createUser(user);

        String errorMsg = createdUser.getCREATION_ERROR();
        if(errorMsg == null){
            return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(createdUser,HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDetails,@PathVariable Integer id){
        UserDto updatedUser = service.updateUser(userDetails,id);

        String errorMsg = updatedUser.getCREATION_ERROR();
        if(errorMsg == null){
            return new ResponseEntity<>(updatedUser,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(updatedUser,HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/edit/changepassword/{id}")
    public ResponseEntity<UserDto> updatePassword(@RequestBody UserPasswordDto request, @PathVariable Integer id){
        String newPassword = request.getNewPassword();
        UserDto updatedUser = service.updateUserPassword(newPassword,id);

        String errorMsg = updatedUser.getCREATION_ERROR();
        if(errorMsg == null){
            return new ResponseEntity<>(updatedUser,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(updatedUser,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/edit/{id}")
    public ResponseEntity<?> deleteUserProfile(@PathVariable Integer id){
        service.deleteUser(id);
        return new ResponseEntity<>("User deleted Successfully",HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> userList = service.getAllUsers();
        return new ResponseEntity<>(userList,HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserProfile(@PathVariable Integer id){
        UserDto userProfile = service.getUserById(id);
        return new ResponseEntity<>(userProfile,HttpStatus.ACCEPTED);
    }
}
