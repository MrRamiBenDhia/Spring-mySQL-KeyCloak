package com.minotore.SpringBootMySql.repository;


import com.minotore.SpringBootMySql.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User findByUID(Long UID);

    User findByemail(String email);

    List<User> findAll();
}
