package com.akers.shopproduct.pojo;

import cn.hutool.json.JSONArray;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.shopproduct.pojo
 * @date:2021-03-31
 */
@Data
@ApiModel(value = "产品Model", description = "产品数据")
public class Product {

    @Id
    private String id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("主图")
    private String main_img;

    @ApiModelProperty("橱窗图jsonArray")
    private String img_list;

    @ApiModelProperty("规格jsonArray")
    private String spec_arr;

    @ApiModelProperty("规格价格区间")
    private String spec_range_price;

    @ApiModelProperty("价格")
    private Double price;

    @ApiModelProperty("价格区间jsonArray")
    private String price_list;



    @ApiModelProperty("单位")
    private String unit;

    @ApiModelProperty("MOQ")
    private Integer moq;

    @ApiModelProperty("库存数量")
    private Long stock_num;

    @ApiModelProperty("销量")
    private Long sales_num;


    @ApiModelProperty("店铺ID")
    private String shopId;

    @ApiModelProperty("参数jsonArray")
    private String parameters;

    @ApiModelProperty("详情")
    private String details;

    @ApiModelProperty("品牌")
    private String banner;


    @ApiModelProperty("类别ID")
    private String categoryId;

    @ApiModelProperty("类别路径")
    private String category_path;

    @ApiModelProperty("创建时间")
    private Date create_time;

    @ApiModelProperty("创建时间")
    private Date update_time;



}
