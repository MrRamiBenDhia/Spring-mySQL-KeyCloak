package com.Spring.SpringBootMysql.repository;

import com.Spring.SpringBootMysql.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepo extends CrudRepository<Client, Long> {
    Client findClientByID(Long ID);

    List<Client> findAll();
}
