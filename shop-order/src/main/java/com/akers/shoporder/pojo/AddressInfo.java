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
public class AddressInfo {

    @Id
    private String id;
    private String country;
    private String state;
    private String city;
    private String street;
    private String zipCode;
    private String phoneNumber;
    private String recipient;
}
