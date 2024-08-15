package com.atguigu.cloud.service;

/**
 * @Author hsj
 * @Description TODO
 * @Date 2024/8/14 15:59
 */
public interface AccountService {
    /**
     * 扣减账户余额
     *
     * @param userId 用户id
     * @param money  本次消费金额
     */
    void decrease(Long userId, Long money);
}
