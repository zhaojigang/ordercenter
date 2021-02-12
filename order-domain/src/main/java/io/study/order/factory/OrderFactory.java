package io.study.order.factory;

import io.study.order.domain.Order;
import io.study.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 订单工厂
 *
 * @author jigang
 */
@Component
public class OrderFactory {
    private static OrderRepository orderRepository;

    @Autowired
    public OrderFactory(OrderRepository repository) {
        orderRepository = repository;
    }

    public static Order createOrder() {
        return new Order(orderRepository);
    }
}
