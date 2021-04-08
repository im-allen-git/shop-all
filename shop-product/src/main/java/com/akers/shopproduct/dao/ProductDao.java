package com.akers.shopproduct.dao;

import com.akers.shopproduct.pojo.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.shopproduct.dao
 * @date:2021-03-31
 */
public interface ProductDao extends MongoRepository<Product, String> {

    // Page<Product> findByShop_id(String shop_id, Pageable pageable);

    List<Product> findByShopId(String shop_id);

}
