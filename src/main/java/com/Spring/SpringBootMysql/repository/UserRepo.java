package com.Spring.SpringBootMysql.repository;


import com.Spring.SpringBootMysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByUID(Long UID);

    User findByemail(String email);

    List<User> findAll();
}
