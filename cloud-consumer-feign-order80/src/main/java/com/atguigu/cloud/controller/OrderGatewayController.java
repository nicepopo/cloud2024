package com.atguigu.cloud.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hsj
 * @Description Micrometer feign调用 gateway例子
 * @Date 2024/7/17 15:26
 */
@RestController
public class OrderGatewayController {

    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping("/feign/gateway/pay/{id}")
    @CircuitBreaker(name = "cloud-payment-service", fallbackMethod = "myCircuitFallback1")
    public ResultData<PayDTO> getPayById(@PathVariable("id") Integer id) {
        return payFeignApi.getGatewayPayById(id);
    }

    @GetMapping("/feign/gateway/pay/getGatewayInfo")
    public ResultData getGatewayInfo() {
        return payFeignApi.getGatewayInfo();
    }

    public ResultData<PayDTO> myCircuitFallback1(Integer id, Throwable t) {
        // 这里是容错处理逻辑，返回备用结果
        return ResultData.fail(ReturnCodeEnum.UNSUPPORTED_GRANT_TYPE.getCode(), "自定义，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~");
    }
}
