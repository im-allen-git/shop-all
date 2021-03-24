package com.akers.shoporder.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.shoporder.pojo
 * @date:2021-03-24
 */
@Data
public class OrderDt {

    @Id
    private String id;
    private String orderNo;
    private String pid;
    private String skuId;
    private String skuInfo;
    private String imgUrl;

    private Double price;
    private Double weight;
    private Double volume;
    private Integer num;
    private Integer status;

    private Date createTime;


}
