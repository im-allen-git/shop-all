package com.akers.shopproduct.service;

import com.akers.shopproduct.dao.ProductDao;
import com.akers.shopproduct.pojo.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.shopproduct.service
 * @date:2021-04-08
 */
@Service
public class ProductService {


    private final ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product createProduct(Product product){
        product.setId(null);
        return this.productDao.save(product);
    }

    public Optional<Product> getInfoById(String id) {
        return this.productDao.findById(id);
    }

    public List<Product> queryInfosByIds(List<String> ids) {
        return (List<Product>) this.productDao.findAllById(ids);
    }

    public List<Product> queryInfosByShopId(String shopId) {
        // return this.productDao.findAllByShopId(shopId, PageRequest.of(0, 0)).getContent();
        return this.productDao.findByShopId(shopId);
    }

    public void updateProduct(String id, Product product) {
        this.productDao.findById(id).ifPresent(e -> {
            BeanUtils.copyProperties(product, e);
            e.setId(id);
            this.productDao.save(e);
        });
    }

}
