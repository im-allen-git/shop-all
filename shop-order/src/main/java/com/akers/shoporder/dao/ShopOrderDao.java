package com.akers.shoporder.dao;

import com.akers.shoporder.ShopOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.malllogin.dao
 * @date:2021-03-22
 */
@Repository
public interface ShopOrderDao extends MongoRepository<ShopOrder, String> {

}
