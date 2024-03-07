package com.Spring.SpringBootMysql.Service;

import com.Spring.SpringBootMysql.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Optional<Client> findByID(Long ID);
    Client addClient(Client client);
    Client updateClient(Client client);
    void deleteClient(Long idClient);

    List<Client> findAll();
}
