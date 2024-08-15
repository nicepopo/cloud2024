package com.atguigu.cloud.service;

/**
 * @Author hsj
 * @Description TODO
 * @Date 2024/8/14 15:02
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
