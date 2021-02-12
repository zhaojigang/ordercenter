package io.study.order.repository;

import io.study.order.domain.Order;
import io.study.order.domain.OrderId;

/**
 * 订单仓储接口
 *
 * @author jigang
 */
public interface OrderRepository {
    /**
     * 保存订单
     *
     * @param order 订单
     */
    void save(Order order);

    /**
     * 根据订单ID获取订单
     * @param orderId
     */
    Order find(OrderId orderId);
}
