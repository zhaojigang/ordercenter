package io.study.order.data;

import io.study.order.domain.Order;
import io.study.order.domain.OrderFactory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderDO 转换器
 *
 * @author jigang
 */
@Mapper
public interface OrderDOConverter {
    OrderDOConverter INSTANCE = Mappers.getMapper(OrderDOConverter.class);

    @Mapping(source = "id.id", target = "id")
    OrderDO toDO(Order order);

    @Mapping(target = "id", expression = "java(OrderId.of(orderDO.getId()))")
    void update(OrderDO orderDO, @MappingTarget Order order);

    default Order fromDO(OrderDO orderDO) {
        Order order = OrderFactory.createOrder();
        INSTANCE.update(orderDO, order);
        return order;
    }

    default List<Order> fromDOList(List<OrderDO> orderDOList) {
        if (orderDOList == null || orderDOList.size()<=0) {
            return new ArrayList<>(0);
        }
        return orderDOList.stream().map(OrderDOConverter.INSTANCE::fromDO).collect(Collectors.toList());
    }
}
