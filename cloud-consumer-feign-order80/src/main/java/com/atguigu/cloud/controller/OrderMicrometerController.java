package com.atguigu.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.atguigu.cloud.apis.PayFeignApi;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hsj
 * @Description Micrometer 链路追踪的例子
 * @Date 2024/7/17 15:26
 */
@RestController
public class OrderMicrometerController {

    @Resource
    private PayFeignApi payFeignApi;

    //=========Micrometer 链路追踪的例子
    @GetMapping(value = "/feign/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id) {
        return payFeignApi.myMicrometer(id);
    }
}
