package io.study.order.facade;

import io.study.order.app.service.OrderAppService;
import io.study.order.domain.Order;
import io.study.order.dto.OrderDTO;
import io.study.order.dto.OrderQueryRequest;
import io.study.order.repository.OrderRepository;
import io.study.order.facade.assembler.OrderDTOAssembler;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单服务实现
 *
 * @author jigang
 */
@DubboService(version = "1.0.0", group = "product")
public class OrderFacadeImpl implements OrderFacade {
    @Resource
    private OrderAppService orderAppService;
    @Resource
    private OrderRepository orderRepository;

    @Override
    public List<OrderDTO> getOrderList(OrderQueryRequest request) {
        List<Order> orderList = orderRepository.findByCondition(request);
        return OrderDTOAssembler.INSTANCE.toDTOList(orderList);
    }

    @Override
    public void createOrder(OrderDTO orderDTO) {
        orderAppService.createOrder(OrderDTOAssembler.INSTANCE.fromDTO(orderDTO));
    }
}
