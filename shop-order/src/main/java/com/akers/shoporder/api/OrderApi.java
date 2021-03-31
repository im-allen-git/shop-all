package com.akers.shoporder.api;

import com.akers.shopcommon.common.CommonResult;
import com.akers.shoporder.pojo.AddressInfo;
import com.akers.shoporder.pojo.OrderDt;
import com.akers.shoporder.pojo.OrderInfo;
import com.akers.shoporder.pojo.OrderInfoShow;
import com.akers.shoporder.service.AddressService;
import com.akers.shoporder.service.OrderDetailsService;
import com.akers.shoporder.service.ShopOrderService;
import com.akers.shoporder.util.PageEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.malllogin.api
 * @date:2021-03-23
 */
@Api(value = "订单接口")
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderApi {

    private final ShopOrderService orderService;

    private final OrderDetailsService orderDetailsService;

    private final AddressService addressService;


    @Autowired
    public OrderApi(ShopOrderService orderService, OrderDetailsService orderDetailsService, AddressService addressService) {
        this.orderService = orderService;
        this.orderDetailsService = orderDetailsService;
        this.addressService = addressService;
    }

    @ApiOperation(value = "订单列表", notes = "订单页")
    @GetMapping("/list/{page}")
    public CommonResult getOrderInfoByUserId(@ApiParam(value = "页码") @PathVariable(value = "page") Integer page) {

        if (null == page || page < 1) {
            page = 1;
        }
        try {
            List<OrderInfo> orderInfoList = orderService.getOrdersByPage(null, page, PageEnum.TWENTY.getSize());
            return CommonResult.success(orderInfoList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("list/page[{}],error:", page, e);
            return CommonResult.failed(e.getMessage());
        }
    }


    @ApiOperation(value = "根据订单和详情信息", notes = "订单页")
    @GetMapping("/{id}")
    public CommonResult getOrderInfoById(@ApiParam(value = "订单ID") @PathVariable(value = "id") String id) {
        try {
            OrderInfo orderBean = orderService.getOrderById(id);
            OrderInfoShow orderInfoShow = new OrderInfoShow();
            if (null != orderBean) {
                BeanUtils.copyProperties(orderBean, orderInfoShow);
                List<OrderDt> dtList = this.orderDetailsService.getOrderDtListByOrderNo(orderBean.getId());
                orderInfoShow.setDtList(dtList);
                AddressInfo addressInfo = this.addressService.getAddressInfoById(orderBean.getAddressId());
                orderInfoShow.setAddressInfo(addressInfo);
            }
            return CommonResult.success(orderInfoShow);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("getOrderInfoById,id[{}],error:", id, e);
            return CommonResult.failed(e.getMessage());
        }
    }


    @ApiOperation(value = "删除订单", notes = "订单页")
    @PostMapping("/deleteOrderInfo")
    public CommonResult deleteAddressInfo(@ApiParam(value = "订单ID") String id) {
        Assert.isTrue(StringUtils.isNotBlank(id), "id null");
        try {
            orderService.deleteOrderInfo(id);
            return CommonResult.success(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("deleteOrderInfo,id[{}],error:", id, e);
            return CommonResult.failed(e.getMessage());
        }
    }

}
