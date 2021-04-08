package com.akers.shopproduct.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.shopproduct.pojo
 * @date:2021-03-31
 */
@Data
@ApiModel("产品规格")
public class PdSpecs {

    private Integer id;

    @ApiModelProperty("图片")
    private String img;

    @ApiModelProperty("属性")
    private String type;

    @ApiModelProperty("属性值")
    private String value;
}
