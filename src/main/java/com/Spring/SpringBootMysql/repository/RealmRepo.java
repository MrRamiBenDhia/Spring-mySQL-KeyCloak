package com.Spring.SpringBootMysql.repository;

import com.Spring.SpringBootMysql.model.Realm;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RealmRepo extends CrudRepository<Realm,Long> {
    Realm findRealmsByID(Long ID);

    List<Realm> findAll();
}
