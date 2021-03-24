package com.akers.shoplogin.dao;

import com.akers.shoplogin.pojo.MallUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.malllogin.dao
 * @date:2021-03-22
 */
@Repository
public interface MallUserDao extends MongoRepository<MallUser, String> {

    Page<MallUser> findMallUsersByNameLike(String name, Pageable pageable);

}
