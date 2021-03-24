package com.akers.shoporder.dao;

import com.akers.shoporder.pojo.AddressInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.malllogin.dao
 * @date:2021-03-22
 */
@Repository
public interface AddressDao extends MongoRepository<AddressInfo, String> {

}
