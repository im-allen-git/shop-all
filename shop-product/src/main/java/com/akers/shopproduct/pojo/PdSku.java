package com.akers.shopproduct.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.shopproduct.pojo
 * @date:2021-03-31
 */
@Data
@ApiModel("产品SKU")
public class PdSku {

    @Id
    private String id;

    @ApiModelProperty("规格组合ID")
    private String sp_comb_ids;
    @ApiModelProperty("价格")
    private Long price;

    @ApiModelProperty("促销价格")
    private Long promotion_price;

    @ApiModelProperty("促销标识 1促销")
    private Integer promotion_flag;

    @ApiModelProperty("重量KG")
    private Long weight;

    @ApiModelProperty("体积L")
    private Long volume;

    @ApiModelProperty("库存数量")
    private Long stock_num;


}
