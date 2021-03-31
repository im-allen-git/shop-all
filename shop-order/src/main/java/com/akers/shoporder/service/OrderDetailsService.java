package com.akers.shoporder.service;

import com.akers.shoporder.dao.OrderDetailsDao;
import com.akers.shoporder.pojo.OrderDt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.shoporder.service
 * @date:2021-03-25
 */
@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsDao orderDetailsDao;


    public List<OrderDt> getOrderDtListByOrderNo(String orderNo) {
        return this.orderDetailsDao.findOrderDtsByOrderNo(orderNo);
    }

    public OrderDt createOrderDt(OrderDt orderDt) {
        orderDt.setId(null);
        return this.orderDetailsDao.save(orderDt);
    }

    public void updateOrderDt(String id, OrderDt orderDt) {
        this.orderDetailsDao.findById(id).ifPresent(u -> {
            BeanUtils.copyProperties(orderDt, u);
            u.setId(id);
            this.orderDetailsDao.save(u);
        });
    }

    public void deleteDt(String id) {
        this.orderDetailsDao.findById(id).ifPresent(oi -> this.orderDetailsDao.delete(oi));
    }

}
