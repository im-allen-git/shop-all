package com.akers.shoporder.dao;

import com.akers.shoporder.pojo.OrderDt;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.malllogin.dao
 * @date:2021-03-22
 */
@Repository
public interface OrderDetailsDao extends MongoRepository<OrderDt, String> {

    List<OrderDt> findOrderDtsByOrderNo(String orderNo);

}
