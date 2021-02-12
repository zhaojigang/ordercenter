package io.study.order.data;

import io.study.order.domain.Order;
import io.study.order.factory.OrderFactory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

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
}
