package com.akers.shoporder.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.shoporder.pojo
 * @date:2021-03-24
 */
@Data
@ApiModel(description = "地址bean")
public class AddressInfo {

    @Id
    private String id;
    @ApiModelProperty("国家")
    private String country;

    @ApiModelProperty("州")
    private String state;

    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("街道")
    private String street;

    @ApiModelProperty("邮编")
    private String zipCode;

    @ApiModelProperty("电话")
    private String phoneNumber;

    @ApiModelProperty("接收人")
    private String recipient;
}
