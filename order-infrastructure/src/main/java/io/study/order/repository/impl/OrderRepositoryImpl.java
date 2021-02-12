package io.study.order.repository.impl;

import io.study.order.data.OrderDAO;
import io.study.order.data.OrderDO;
import io.study.order.data.OrderDOConverter;
import io.study.order.domain.Order;
import io.study.order.domain.OrderId;
import io.study.order.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 订单仓储实现类
 *
 * @author jigang
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Resource
    private OrderDAO orderDAO;

    @Override
    public void save(Order order) {
        orderDAO.insertSelective(OrderDOConverter.INSTANCE.toDO(order));
    }

    @Override
    public Order find(OrderId orderId) {
        OrderDO orderDO = orderDAO.selectByPrimaryKey(orderId.getId());
        return OrderDOConverter.INSTANCE.fromDO(orderDO);
    }
}
