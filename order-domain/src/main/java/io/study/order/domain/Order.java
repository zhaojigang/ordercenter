package io.study.order.domain;

import common.ddd.AggregateRoot;
import io.study.order.repository.OrderRepository;
import lombok.Data;

/**
 * 订单聚合根
 *
 * @author jigang
 */
@Data
@AggregateRoot
public class Order {
    /**
     * 订单 ID
     */
    private OrderId id;
    /**
     * 订单名称
     */
    private String name;
    /**
     * 订单仓储
     */
    private OrderRepository orderRepository;

    public Order(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * 创建订单
     *
     * @param order
     */
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
