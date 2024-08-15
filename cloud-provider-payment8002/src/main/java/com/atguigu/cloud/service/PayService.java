package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;

import java.util.List;

/**
 * @Author hsj
 * @Description TODO
 * @Date 2024/7/2 16:15
 */
public interface PayService {
    int add(Pay pay);

    int update(Pay pay);

    int delete(Integer id);

    Pay getPayById(Integer id);

    List<Pay> getAll();

}
