package io.study.order.facade.assembler;

import io.study.order.domain.Order;
import io.study.order.dto.OrderDTO;
import io.study.order.factory.OrderFactory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderDTO<=>Order 转换器
 *
 * @author jigang
 */
@Mapper
public interface OrderDTOAssembler {
    OrderDTOAssembler INSTANCE = Mappers.getMapper(OrderDTOAssembler.class);
    /**
     * DTO 转 Entity
     * @param dto
     * @return
     */
    default Order fromDTO(OrderDTO dto) {
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
    OrderDTO toDTO(Order order);

    @Mapping(target = "id", expression = "java(OrderId.of(orderDTO.getId()))")
    void update(OrderDTO orderDTO, @MappingTarget Order order);

    default List<OrderDTO> toDTOList(List<Order> orderList) {
        if (orderList == null || orderList.size()<=0) {
            return new ArrayList<>(0);
        }
        return orderList.stream().map(OrderDTOAssembler.INSTANCE::toDTO).collect(Collectors.toList());
    }
}
