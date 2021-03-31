package com.akers.shoporder.service;

import com.akers.shoporder.dao.ShopOrderDao;
import com.akers.shoporder.pojo.OrderInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.shoporder.service
 * @date:2021-03-25
 */
@Service
public class ShopOrderService {

    @Autowired
    private ShopOrderDao shopOrderDao;


    public List<OrderInfo> getOrdersByPage(String userId, int page, int size) {
        Page<OrderInfo> byUserId = this.shopOrderDao.findByUserId(userId, PageRequest.of(page, size));
        return byUserId.getContent();
    }

    public OrderInfo getOrderById(String id){
        return this.shopOrderDao.findById(id).orElse(null);
    }

    public OrderInfo createOrderInfo(OrderInfo orderInfo) {
        orderInfo.setId(null);
        return this.shopOrderDao.save(orderInfo);
    }

    public void updateOrderInfo(String id, OrderInfo orderInfo) {
        this.shopOrderDao.findById(id).ifPresent(oi -> {
            BeanUtils.copyProperties(orderInfo, oi);
            oi.setId(id);
            this.shopOrderDao.save(oi);
        });
    }

    public void deleteOrderInfo(String id){
        this.shopOrderDao.findById(id).ifPresent(oi-> this.shopOrderDao.delete(oi));
    }

}
