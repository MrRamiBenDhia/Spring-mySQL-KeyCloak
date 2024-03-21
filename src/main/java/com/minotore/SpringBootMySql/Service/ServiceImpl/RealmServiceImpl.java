package com.minotore.SpringBootMySql.Service.ServiceImpl;

import com.minotore.SpringBootMySql.Service.RealmService;
import com.minotore.SpringBootMySql.model.Client;
import com.minotore.SpringBootMySql.model.Realm;
import com.minotore.SpringBootMySql.model.User;
import com.minotore.SpringBootMySql.repository.ClientRepo;
import com.minotore.SpringBootMySql.repository.RealmRepo;
import com.minotore.SpringBootMySql.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RealmServiceImpl implements RealmService {

    @Autowired
    private RealmRepo realmRepo;
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private UserRepo userRepo;

    public void addUser(Long idRealm, Long idUser) {
        Realm realm = realmRepo.findById(idRealm).orElseThrow(() -> {
            return new RuntimeException("No Realm with this ID");
        });

        User user = userRepo.findById(idUser).orElseThrow(() -> {
            return new RuntimeException("No User with this UID");
        });

        user.setRealm(realm);
        userRepo.save(user);

    }

    public void addClient(Long idRealm, Long idClient) {
        Realm realm = realmRepo.findById(idRealm).orElseThrow(() -> {
            return new RuntimeException("No Realm with this ID");
        });

        Client client = clientRepo.findById(idClient).orElseThrow(() -> {
            return new RuntimeException("No client with this UID");
        });

        client.setRealm(realm);
        clientRepo.save(client);

    }


    @Override
    public Optional<Realm> findByID(Long ID) {
        return realmRepo.findById(ID);
    }

    @Override
    public Realm addRealm(Realm realm) {
        return realmRepo.save(realm);
    }

    @Override
    public Realm updateRealm(Realm realm) {
        return realmRepo.save(realm);
    }

    @Override
    public void deleteRealm(Long idRealm) {
        realmRepo.deleteById(idRealm);
    }

    @Override
    public List<Realm> findAll() {
        return realmRepo.findAll();
    }
}
