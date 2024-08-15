package com.atguigu.cloud.controller;

import cn.hutool.core.bean.BeanUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author hsj
 * @Description TODO
 * @Date 2024/7/2 16:24
 */
@RestController
@RefreshScope//动态刷新配置
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping("/pay")
    public ResultData add(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtil.copyProperties(payDTO, pay);
        return ResultData.success(payService.add(pay));
    }

    @PutMapping("/pay")
    public ResultData update(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtil.copyProperties(payDTO, pay);
        return ResultData.success(payService.update(pay));
    }

    @DeleteMapping("/pay/{id}")
    public ResultData delete(@PathVariable("id") Integer id) {
        return ResultData.success(payService.delete(id));
    }

    @GetMapping("/pay/{id}")
    public ResultData<PayDTO> getPayById(@PathVariable("id") Integer id) {
        Pay pay = payService.getPayById(id);
        PayDTO payDTO = new PayDTO();
        BeanUtil.copyProperties(pay, payDTO);
        return ResultData.success(payDTO);
    }

    @GetMapping("/pay")
    public ResultData<List<PayDTO>> getAll() {
        List<Pay> list = payService.getAll();
        List<PayDTO> payDTOList = list.stream().map(pay -> {
            PayDTO payDTO = new PayDTO();
            BeanUtil.copyProperties(pay, payDTO);
            return payDTO;
        }).collect(Collectors.toList());
        return ResultData.success(payDTOList);
    }


    @Value("${key}")
    private String key;

    @GetMapping("/pay/getConsulInfo")
    public ResultData getConsulInfo() {
        return ResultData.success(key + ":8002");
    }
}
