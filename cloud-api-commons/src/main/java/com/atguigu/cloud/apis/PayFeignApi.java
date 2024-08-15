package com.atguigu.cloud.apis;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author hsj
 * @Description TODO
 * @Date 2024/7/15 17:42
 */
@FeignClient(name = "cloud-payment-service")
public interface PayFeignApi {

    @PostMapping("/pay")
    public ResultData add(@RequestBody PayDTO payDTO);

    @PutMapping("/pay")
    public ResultData update(@RequestBody PayDTO payDTO);

    @DeleteMapping("/pay/{id}")
    public ResultData delete(@PathVariable("id") Integer id);

    @GetMapping("/pay/{id}")
    public ResultData<PayDTO> getPayById(@PathVariable("id") Integer id);

    @GetMapping("/pay")
    public ResultData<List<PayDTO>> getAll();

    @GetMapping("/pay/getConsulInfo")
    public ResultData getConsulInfo();

    /**
     * Resilience4j CircuitBreaker 的例子
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id);

    /**
     * Micrometer 链路追踪的例子
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id);

    /**
     * 网关获取详情
     * @param id
     * @return
     */
    @GetMapping("/gateway/pay/{id}")
    public ResultData<PayDTO> getGatewayPayById(@PathVariable("id") Integer id);
    /**
     * 网关获取详情
     * @return
     */
    @GetMapping("/gateway/pay/getGatewayInfo")
    public ResultData getGatewayInfo();
}
