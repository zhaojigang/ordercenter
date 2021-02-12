package io.study.order.app.service;

import io.study.order.domain.Order;
import org.springframework.stereotype.Service;

/**
 * 订单应用服务
 *
 * @author jigang
 */
@Service
public class OrderAppService {
    /**
     * 创建一个订单
     *
     * @param order
     */
    public void createOrder(Order order) {
        /**
         * 存储订单
         */
        order.saveOrder(order);
        /**
         * 扣减库存
         */

    }
}
