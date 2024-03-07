package com.Spring.SpringBootMysql.controller;


import com.Spring.SpringBootMysql.Service.RealmService;
import com.Spring.SpringBootMysql.model.Realm;
import com.Spring.SpringBootMysql.repository.RealmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/realm")
@Controller
public class RealmController {
    @Autowired
    RealmRepo realmRepo;

    @Autowired
    RealmService realmService;


    @GetMapping("/")
    public List<Realm> getAllRealm() {
        return realmService.findAll();
    }
    @GetMapping("/{id}")
    public Realm getRealmById(@PathVariable("id") Long id) {
        System.out.println("!~~~~~~~~~~~~~~~~~~~!");
        System.out.println(id);
        System.out.println("!~~~~~~~~~~~~~~~~~~~!");

        return realmService.findByID(id).orElse(new Realm());
    }

    @PostMapping("/")
    public Realm createRealm(@RequestBody Realm realm) {
        return realmService.addRealm(realm);
    }

    @PatchMapping("/{id}")

    public Realm updateRealm(@PathVariable("id") Long id, @RequestBody Realm realm) {
        if(realm.getID()==null){
            realm.setID(id);
        }
        return realmService.updateRealm(realm);
    }

    @DeleteMapping("/{id}")
    public void deleteRealm(@PathVariable("id") Long id){
        realmService.deleteRealm(id);

    }

}
