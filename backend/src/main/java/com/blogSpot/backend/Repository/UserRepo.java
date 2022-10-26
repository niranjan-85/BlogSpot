package com.blogSpot.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogSpot.backend.Beans.UserBean;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<UserBean, Integer> {
    public Boolean existsUsersByUsername(String username);

    public Boolean existsUsersByuseremail(String email);
}
