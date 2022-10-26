package com.blogSpot.backend.Services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogSpot.backend.Beans.UserBean;
import com.blogSpot.backend.Exceptions.ResourceNotFoundException;
import com.blogSpot.backend.Payloads.UserDto;
import com.blogSpot.backend.Repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    // helper methods

    public boolean usernameExists(String username){
        return userRepo.existsUsersByUsername(username);
    }

    public boolean emailExists(String email){
        return userRepo.existsUsersByuseremail(email);
    }

    // application service methods
    @Override
    public UserDto createUser(UserDto userDto) {
        if( usernameExists(userDto.getUsername()) ){
            userDto.setCREATION_ERROR("Username Already in use");
            return userDto;
        }
        if( emailExists(userDto.getUseremail()) ){
            userDto.setCREATION_ERROR("Email Already in use");
            return userDto;
        }
        userDto.setCREATION_ERROR("");
        UserBean user = dtoToUser(userDto);
        UserBean newUser = userRepo.save(user);
        return userToDto(newUser);
    }


    @Override
    public UserDto updateUser(UserDto userDto, Integer user_Id) {

        // Find user by ID
        // if not found throw exception
        UserBean existingUser = userRepo.findById(user_Id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", user_Id));

        // Check for same username
        if (!existingUser.getUsername().equals( userDto.getUsername())) {

            //check if username is already in use
            if( usernameExists(userDto.getUsername()) ){
                userDto.setCREATION_ERROR("Username Already in use");
                return userDto;
            }

            //check if email is used by other user
            if(!userDto.getUseremail().equals(existingUser.getUseremail())){

                if( emailExists(userDto.getUseremail()) ){
                    userDto.setCREATION_ERROR("Email Already in use");
                    return userDto;
                }

                userDto.setCREATION_ERROR("");

                String updatedName = userDto.getName();
                String updatedUserName = userDto.getUsername();
                String updatedUserEmail = userDto.getUseremail();
                String updatedUserWork = userDto.getUser_work();

                existingUser.setName(updatedName);
                existingUser.setUseremail(updatedUserEmail);
                existingUser.setUsername(updatedUserName);
                existingUser.setUser_work(updatedUserWork);

                UserBean updatedUser = userRepo.save(existingUser);
                return userToDto(updatedUser);

            }
            userDto.setCREATION_ERROR("Email Cannot be same");
            return userDto;

        }
        userDto.setCREATION_ERROR("Username Cannot be same");
        return userDto;
    }

    @Override
    public UserDto updateUserPassword(String newPassword, Integer user_Id) {

        UserBean user = userRepo.findById(user_Id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", user_Id));

        // check if old password = new password
        String oldPassword = user.getUser_password();
        if (!oldPassword.equals(newPassword)) {
            user.setUser_password(newPassword);
            UserBean updatedUser = userRepo.save(user);
            return userToDto(updatedUser);
        } else {
            UserDto userdto = userToDto(user);
            userdto.setCREATION_ERROR("Old and new passwords cannot be same");
            return userdto;
        }
    }

    @Override
    public UserDto getUserById(Integer user_Id) {
        UserBean user = userRepo.findById(user_Id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", user_Id));

        return userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserBean> allUsers = userRepo.findAll();
        List<UserDto> users = allUsers
                .stream()
                .map(user -> userToDto(user))
                .collect(Collectors.toList());

        return users;
    }

    @Override
    public void deleteUser(Integer user_Id) {
        UserBean user = userRepo.findById(user_Id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", user_Id));
        userRepo.delete(user);
    }

    // Mapper methods

    public UserBean dtoToUser(UserDto userDto) {
        UserBean user = this.modelMapper.map(userDto, UserBean.class);
        return user;
    }

    public UserDto userToDto(UserBean user) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
