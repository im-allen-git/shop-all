package com.akers.shoplogin.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.malllogin.pojo
 * @date:2021-03-22
 */
@Data
@Document(collection = "mall_user")
public class MallUser {
    @Id
    private String id;
    @NonNull
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("邮箱")
    @NonNull
    private String email;
    private String phone;
    private String password;
    private String birthday;
    private Integer amount;
    private String token;
    private Date createTime;
    private Date lastLoginTime;

}
