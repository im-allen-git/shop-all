package com.akers.shoplogin.service;

import com.akers.shoplogin.dao.MallUserDao;
import com.akers.shoplogin.pojo.MallUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.malllogin.service
 * @date:2021-03-22
 */
@Service
public class MallUserService {

    @Autowired
    private MallUserDao mallUserDao;


    public List<MallUser> getUsers() {
        return mallUserDao.findAll();
    }

    public Optional<MallUser> getUser(String id) {
        return mallUserDao.findById(id);
    }

    public MallUser createUser(MallUser user) {
        user.setId(null);
        return mallUserDao.save(user);
    }

    public void updateUser(String id, MallUser user) {
        mallUserDao.findById(id).ifPresent(u -> {
            u.setBirthday(user.getBirthday());
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            u.setPhone(user.getPhone());
            u.setToken(user.getToken());
            mallUserDao.save(u);
        });
    }

    public void deleteUser(String id) {
        this.mallUserDao.findById(id).ifPresent(u -> {
            this.mallUserDao.delete(u);
        });
    }

}
