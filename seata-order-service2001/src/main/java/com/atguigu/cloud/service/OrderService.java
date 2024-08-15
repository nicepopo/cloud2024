package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Order;

/**
 * @Author hsj
 * @Description TODO
 * @Date 2024/8/14 11:02
 */
public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}
