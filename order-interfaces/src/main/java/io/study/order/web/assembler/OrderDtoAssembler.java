package io.study.order.web.assembler;

import io.study.order.domain.Order;
import io.study.order.factory.OrderFactory;
import io.study.order.web.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * OrderDTO<=>Order 转换器
 *
 * @author jigang
 */
@Mapper
public interface OrderDtoAssembler {
    OrderDtoAssembler INSTANCE = Mappers.getMapper(OrderDtoAssembler.class);
    /**
     * DTO 转 Entity
     * @param dto
     * @return
     */
    default Order fromDTO(OrderDto dto) {
        Order order = OrderFactory.createOrder();
        INSTANCE.update(dto, order);
        return order;
    }

    /**
     * Entity 转 DTO
     * @param order
     * @return
     */
    @Mapping(source = "id.id", target = "id")
    OrderDto toDTO(Order order);

    @Mapping(target = "id", expression = "java(OrderId.of(orderDto.getId()))")
    void update(OrderDto orderDto, @MappingTarget Order order);
}
