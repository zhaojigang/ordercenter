package io.study.order.domain;

import io.study.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 订单工厂
 * 作用：创建聚合。工厂的好处：
 * 1. 创建复杂的聚合，简化客户端的使用：例如 Order 的创建需要注入资源库，订单创建后，直接发布订单创建事件
 * 2. 可读性好（更加符合通用语言），比如 对于创建订单，createOrder 就比 new Order 的语义更加明确
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
        // 创建订单之后，可以发布订单创建事件
    }
}
