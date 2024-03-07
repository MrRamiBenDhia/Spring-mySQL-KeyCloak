package com.Spring.SpringBootMysql.repository;


import com.Spring.SpringBootMysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User findByUID(Long UID);

    User findByemail(String email);

    List<User> findAll();
}
