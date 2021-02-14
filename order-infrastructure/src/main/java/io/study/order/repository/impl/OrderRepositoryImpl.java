package io.study.order.repository.impl;

import io.study.order.data.OrderDAO;
import io.study.order.data.OrderDO;
import io.study.order.data.OrderDOConverter;
import io.study.order.domain.Order;
import io.study.order.domain.OrderId;
import io.study.order.dto.OrderQueryRequest;
import io.study.order.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单资源库实现类
 *
 * @author jigang
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Resource
    private OrderDAO orderDAO;

    @Override
    public void add(Order order) {
        orderDAO.insertSelective(OrderDOConverter.INSTANCE.toDO(order));
    }

    @Override
    public Order orderOfId(OrderId orderId) {
        OrderDO orderDO = orderDAO.selectByPrimaryKey(orderId.getId());
        return OrderDOConverter.INSTANCE.fromDO(orderDO);
    }

    @Override
    public List<Order> ordersOfCondition(OrderQueryRequest request) {
        List<OrderDO> orderDOList = orderDAO.selectByCondition(request);
        return OrderDOConverter.INSTANCE.fromDOList(orderDOList);
    }
}
