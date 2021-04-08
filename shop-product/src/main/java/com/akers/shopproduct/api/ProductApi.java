package com.akers.shopproduct.api;

import com.akers.shopcommon.common.CommonPage;
import com.akers.shopcommon.common.CommonResult;
import com.akers.shopproduct.pojo.Product;
import com.akers.shopproduct.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.shopproduct.api
 * @date:2021-04-08
 */
@Api(value = "产品单页API", tags = "产品单页")
@RestController
@Slf4j
@RequestMapping("/productApi")
public class ProductApi {


    private final ProductService productService;

    @Autowired
    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "创建产品")
    @PostMapping("/createProduct")
    public CommonResult<Product> createProduct(@RequestBody Product product) {
        Assert.notNull(product, "product null");
        product = productService.createProduct(product);
        return CommonResult.success(product);
    }


    @ApiOperation(value = "根据id获取产品信息")
    @GetMapping("/info/{id}")
    public CommonResult<Product> getInfoById(@PathVariable("id") String id) {
        Optional<Product> infoById = productService.getInfoById(id);
        return CommonResult.success(infoById.get());
    }


    @ApiOperation(value = "根据店铺ID获取产品信息")
    @GetMapping("/shop/{shopId}")
    public CommonPage<Product> getInfoByShopId(@PathVariable("shopId") String shopId) {
        List<Product> products = productService.queryInfosByShopId(shopId);
        return CommonPage.restPage(products);
    }


}
