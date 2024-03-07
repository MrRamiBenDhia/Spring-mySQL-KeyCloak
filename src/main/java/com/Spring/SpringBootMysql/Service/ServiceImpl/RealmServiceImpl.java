package com.Spring.SpringBootMysql.Service.ServiceImpl;

import com.Spring.SpringBootMysql.Service.RealmService;
import com.Spring.SpringBootMysql.model.Realm;
import com.Spring.SpringBootMysql.repository.RealmRepo;
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
