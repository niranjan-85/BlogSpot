package com.blogSpot.backend.Payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    // this class will only be used to transefer data
    // thus not fiddling with the Beans created

    private int user_id;
    private String name;
    private String username;
    private String useremail;
    private String user_role;
    private String user_work;
    private String user_password;
    private String CREATION_ERROR;

}
