package com.minotore.SpringBootMySql.repository;

import com.minotore.SpringBootMySql.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepo extends CrudRepository<Client, Long> {
    Client findClientByID(Long ID);

    List<Client> findAll();
}
