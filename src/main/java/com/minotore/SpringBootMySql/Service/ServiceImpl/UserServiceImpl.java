package com.minotore.SpringBootMySql.Service.ServiceImpl;

import com.minotore.SpringBootMySql.Service.UserService;
import com.minotore.SpringBootMySql.model.User;
import com.minotore.SpringBootMySql.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepo userRepo;

    @Override
    public Optional<User> findByUID(Long UID) {
        return userRepo.findById(UID);
    }

    @Override
    public User findByemail(String emailId) {
        return userRepo.findByemail(emailId);
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public User addUser(User user) {
//        user.setUID(user.getUID());
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepo.save(user);
    }
}
