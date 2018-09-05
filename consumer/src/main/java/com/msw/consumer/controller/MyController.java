package com.msw.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lianlianpay.cb.common.domain.ResultRich;
import com.lianpay.fund.risk.enums.AmountUnitEnum;
import com.lianpay.fund.risk.intercept.dto.WithdrawCheckDetailDTO;
import com.lianpay.fund.risk.intercept.service.IBLWithdrawInterceptCacheService;
import com.msw.entity.User;
import com.msw.provider.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class MyController {
    @Reference
    UserService userService;

    @Reference
    IBLWithdrawInterceptCacheService blWithdrawInterceptCacheService;

    @GetMapping("/cache")
    public ResultRich<Boolean> cache(){
        WithdrawCheckDetailDTO dto = new WithdrawCheckDetailDTO();
        dto.setCorrelationID(UUID.randomUUID().toString());
        dto.setPartnerID("201809031600115048");
        dto.setPartnerBill("cc2018090317843");
        dto.setAmount("100000000000");
        dto.setCollectionName("沈徐伟");
        dto.setCollectionNumber("20180904685838311");
        dto.setAmountUnit(AmountUnitEnum.L.getTagCode());
        return blWithdrawInterceptCacheService.cacheWithdrawDetail(dto);
    }

    @GetMapping("/getbyid")
    public User getById(@RequestParam("id") int id){
        return userService.getUserById(id);
    }

    @GetMapping("/getUserList")
    public List<User> getUserList(@RequestParam("id") int id){
        return userService.getUserList("");
    }

}
