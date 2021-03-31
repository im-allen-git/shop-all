package com.akers.shoporder.api;

import com.akers.shopcommon.common.CommonResult;
import com.akers.shoporder.pojo.AddressInfo;
import com.akers.shoporder.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;


/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.malllogin.api
 * @date:2021-03-23
 */
@Api(value = "地址接口")
@Slf4j
@RestController
@RequestMapping("/address")
public class AddressApi {


    @Autowired
    private AddressService addressService;

    @ApiOperation(value = "根据ID获取地址信息", notes = "地址页")
    @GetMapping("/{id}")
    public CommonResult getAddressInfoById(@ApiParam(value = "地址ID") @PathVariable(value = "id") String id) {
        try {
            AddressInfo info = addressService.getAddressInfoById(id);
            return CommonResult.success(info);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("getAddressInfoById,id[{}],error:", id, e);
            return CommonResult.failed(e.getMessage());
        }
    }


    @ApiOperation(value = "新增地址", notes = "地址页")
    @PostMapping("/createAddressInfo")
    public CommonResult createAddressInfo(AddressInfo addressInfo) {
        Assert.notNull(addressInfo, "addressInfo is null");
        Assert.isTrue(StringUtils.isNotBlank(addressInfo.getCountry()), "country null");
        Assert.isTrue(StringUtils.isNotBlank(addressInfo.getRecipient()), "recipient null");
        Assert.isTrue(StringUtils.isNotBlank(addressInfo.getPhoneNumber()), "phoneNumber null");
        Assert.isTrue(StringUtils.isNotBlank(addressInfo.getStreet()), "street null");
        try {
            AddressInfo info = addressService.createAddressInfo(addressInfo);
            return CommonResult.success(info);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("createAddressInfo,addressInfo[{}],error:", addressInfo, e);
            return CommonResult.failed(e.getMessage());
        }
    }

    @ApiOperation(value = "更新地址", notes = "地址页")
    @PostMapping("/updateAddressInfo")
    public CommonResult updateAddressInfo(AddressInfo addressInfo) {
        Assert.notNull(addressInfo, "addressInfo is null");
        Assert.isTrue(StringUtils.isNotBlank(addressInfo.getId()), "id null");
        Assert.isTrue(StringUtils.isNotBlank(addressInfo.getCountry()), "country null");
        Assert.isTrue(StringUtils.isNotBlank(addressInfo.getRecipient()), "recipient null");
        Assert.isTrue(StringUtils.isNotBlank(addressInfo.getPhoneNumber()), "phoneNumber null");
        Assert.isTrue(StringUtils.isNotBlank(addressInfo.getStreet()), "street null");
        try {
            addressService.updateAddressInfo(addressInfo.getId(), addressInfo);
            return CommonResult.success(addressInfo);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("updateAddressInfo,addressInfo[{}],error:", addressInfo, e);
            return CommonResult.failed(e.getMessage());
        }
    }

    @ApiOperation(value = "删除地址", notes = "地址页")
    @PostMapping("/deleteAddressInfo")
    public CommonResult deleteAddressInfo(@ApiParam(value = "地址ID") String id) {
        Assert.isTrue(StringUtils.isNotBlank(id), "id null");
        try {
            addressService.deleteAddressInfo(id);
            return CommonResult.success(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("deleteAddressInfo,id[{}],error:", id, e);
            return CommonResult.failed(e.getMessage());
        }
    }

}
