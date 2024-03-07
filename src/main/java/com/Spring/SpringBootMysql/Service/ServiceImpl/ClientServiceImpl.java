package com.Spring.SpringBootMysql.Service.ServiceImpl;

import com.Spring.SpringBootMysql.Service.ClientService;
import com.Spring.SpringBootMysql.model.Client;
import com.Spring.SpringBootMysql.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepo clientRepo;
    @Override
    public Optional<Client> findByID(Long ID) {
        return clientRepo.findById(ID);
    }

    @Override
    public Client addClient(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public void deleteClient(Long idClient) {
        clientRepo.deleteById(idClient);
    }


    @Override
    public List<Client> findAll() {
        return clientRepo.findAll();
    }
}
