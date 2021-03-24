package com.akers.shoporder.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.shoporder.pojo
 * @date:2021-03-24
 */
@Data
public class OrderInfo {

    @Id
    private String id;
    private String userId;
    private Double productCost;
    private Double totalPrice;
    private Double discount;
    private Double freight;
    private String transportationMode;
    private String addressId;

    private AddressInfo addressInfo;


}
