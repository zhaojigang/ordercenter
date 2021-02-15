package io.study.order.web;

import io.study.order.app.service.OrderAppService;
import io.study.order.domain.Order;
import io.study.order.domain.OrderId;
import io.study.order.dto.OrderDTO;
import io.study.order.repository.OrderRepository;
import io.study.order.assembler.OrderDTOAssembler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Order 控制器
 *
 * @author jigang
 */
@Api("订单控制器")
@RestController
@RequestMapping("order")
public class OrderController {
    @Resource
    private OrderAppService orderAppService;
    @Resource
    private OrderRepository orderRepository;

    /**
     * 创建一个订单
     *
     * @param orderDTO
     */
    @ApiOperation("创建订单")
    @PostMapping("/create")
    public void createOrder(@RequestBody OrderDTO orderDTO) {
        orderAppService.createOrder(OrderDTOAssembler.INSTANCE.fromDTO(orderDTO));
    }

    /**
     * 查询一个订单
     *
     * @param id 订单ID
     * @return
     */
    @ApiOperation("根据订单ID获取订单")
    @GetMapping("/find/{id}")
    public OrderDTO findOrder(@PathVariable Long id) {
        Order order = orderRepository.orderOfId(OrderId.of(id));
        return OrderDTOAssembler.INSTANCE.toDTO(order);
    }
}
