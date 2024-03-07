package com.Spring.SpringBootMysql.Service;

import com.Spring.SpringBootMysql.model.Realm;

import java.util.List;
import java.util.Optional;

public interface RealmService {
    Optional<Realm> findByID(Long ID);
    Realm addRealm(Realm realm);
    Realm updateRealm(Realm realm);
    void deleteRealm(Long idRealm);
    List<Realm> findAll();
}
