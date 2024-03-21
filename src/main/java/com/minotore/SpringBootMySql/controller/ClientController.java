package com.minotore.SpringBootMySql.controller;


import com.minotore.SpringBootMySql.Service.ClientService;
import com.minotore.SpringBootMySql.model.Client;
import com.minotore.SpringBootMySql.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@Controller
public class ClientController {
    @Autowired
    ClientRepo clientRepo;

    @Autowired
    ClientService clientService;


    @GetMapping
    public List<Client> getAllClient() {
        return clientService.findAll();
    }
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable("id") Long id) {
        return clientService.findByID(id).orElse(new Client());
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PatchMapping("/{id}")
    public Client updateClient(@PathVariable("id") Long id, @RequestBody Client client) {
        if(client.getID()==null){
            client.setID(id);
        }
        return clientService.updateClient(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") Long id){
        clientService.deleteClient(id);

    }

}
