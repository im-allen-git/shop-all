package com.akers.shoporder.service;

import com.akers.shoporder.dao.AddressDao;
import com.akers.shoporder.pojo.AddressInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: JiangXW
 * @version: v1.0
 * @description: com.akers.shoporder.service
 * @date:2021-03-25
 */
@Service
public class AddressService {


    @Autowired
    private AddressDao addressDao;

    public AddressInfo getAddressInfoById(String id) {
        return this.addressDao.findById(id).orElse(null);
    }

    public AddressInfo createAddressInfo(AddressInfo addressInfo) {
        addressInfo.setId(null);
        return this.addressDao.save(addressInfo);
    }

    public void updateAddressInfo(String id, AddressInfo addressInfo) {
        this.addressDao.findById(id).ifPresent(u -> {
            BeanUtils.copyProperties(addressInfo, u);
            u.setId(id);
            this.addressDao.save(u);
        });
    }

    public void deleteAddressInfo(String id) {
        this.addressDao.findById(id).ifPresent(ad -> this.addressDao.delete(ad));
    }

}
