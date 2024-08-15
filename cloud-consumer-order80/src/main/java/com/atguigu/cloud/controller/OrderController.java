package com.atguigu.cloud.controller;

import cn.hutool.core.bean.BeanUtil;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author hsj
 * @Description TODO
 * @Date 2024/7/10 20:06
 */
@RestController
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";//写死，硬编码
    public static final String PAYMENT_URL = "http://cloud-payment-service";//服务注册中心上的微服务名称

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/pay/{id}")
    public ResultData getPayById(@PathVariable("id") Integer id) {
        ResultData resultData = restTemplate.getForObject(PAYMENT_URL + "/pay/" + id, ResultData.class, id);
        return resultData;
    }

    @PostMapping("/consumer/pay")
    public ResultData getPayById(@RequestBody PayDTO payDTO) {
        ResultData resultData = restTemplate.postForObject(PAYMENT_URL + "/pay", payDTO, ResultData.class);
        return resultData;
    }

    @GetMapping("/consumer/pay/getConsulInfo")
    public ResultData getConsulInfo() {
        ResultData resultData = restTemplate.getForObject(PAYMENT_URL + "/pay/getConsulInfo", ResultData.class,"");
        return resultData;
    }
}
