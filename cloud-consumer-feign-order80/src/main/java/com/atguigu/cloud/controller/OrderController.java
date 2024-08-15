package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @Author hsj
 * @Description TODO
 * @Date 2024/7/10 20:06
 */
@RestController
public class OrderController {

    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping("/consumer/pay/{id}")
    public ResultData getPayById(@PathVariable("id") Integer id) {
        ResultData resultData = payFeignApi.getPayById(id);
        return resultData;
    }

    @PostMapping("/consumer/pay")
    public ResultData add(@RequestBody PayDTO payDTO) {
        ResultData resultData = payFeignApi.add(payDTO);
        return resultData;
    }

    @GetMapping("/consumer/pay/getConsulInfo")
    public ResultData getConsulInfo() {
        ResultData resultData = payFeignApi.getConsulInfo();
        return resultData;
    }

    @DeleteMapping("/consumer/pay/{id}")
    public ResultData delete(@PathVariable("id") Integer id) {
        return ResultData.success(payFeignApi.delete(id));
    }
}
