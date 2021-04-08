package com.akers.shoplogin.api;

import com.akers.shopcommon.common.CommonPage;
import com.akers.shopcommon.common.CommonResult;
import com.akers.shoplogin.pojo.MallUser;
import com.akers.shoplogin.service.MallUserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.malllogin.api
 * @date:2021-03-23
 */
@Api(value = "客户登录接口")
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginApi {


    @Autowired
    private MallUserService userService;


    @ApiOperation(value = "获取用户列表")
    @GetMapping("/list")
    public CommonPage<MallUser> list() {
        List<MallUser> users = userService.getUsers();
        return CommonPage.restPage(users);
    }

    @ApiOperation(value = "获取客户信息")
    @GetMapping("/user/{id}")
    public CommonResult<MallUser> getUserById(@PathVariable("id") String id) {
        Optional<MallUser> user = userService.getUser(id);
        return CommonResult.success(user.get());
    }


    @ApiOperation(value = "注册客户信息")
    @PostMapping("/register")
    public CommonResult<MallUser> registerUser(@RequestBody MallUser user) {
        Assert.notNull(user, "user null");
        Assert.isTrue(StringUtils.isNotBlank(user.getName()), "name null");
        Assert.isTrue(StringUtils.isNotBlank(user.getEmail()), "email null");
        user.setToken(UUID.randomUUID().toString());
        user = userService.createUser(user);
        return CommonResult.success(user);
    }

    @ApiOperation(value = "更新客户信息")
    @PostMapping("/updateUser")
    public CommonResult<MallUser> updateUser(@RequestBody MallUser user) {
        Assert.notNull(user, "user null");
        Assert.isTrue(StringUtils.isNotBlank(user.getId()), "id null");
        Assert.isTrue(StringUtils.isNotBlank(user.getName()), "name null");
        Assert.isTrue(StringUtils.isNotBlank(user.getEmail()), "email null");
        userService.updateUser(user.getId(), user);
        return CommonResult.success(user);
    }

}
