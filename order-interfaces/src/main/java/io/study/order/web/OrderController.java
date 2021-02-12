package io.study.order.web;

import io.study.order.app.service.OrderAppService;
import io.study.order.domain.Order;
import io.study.order.domain.OrderId;
import io.study.order.repository.OrderRepository;
import io.study.order.web.assembler.OrderDtoAssembler;
import io.study.order.web.dto.OrderDto;
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
     * @param orderDto
     */
    @ApiOperation("创建订单")
    @PostMapping("/create")
    public void createOrder(@RequestBody OrderDto orderDto) {
        orderAppService.createOrder(OrderDtoAssembler.INSTANCE.fromDTO(orderDto));
    }

    /**
     * 查询一个订单
     *
     * @param id 订单ID
     * @return
     */
    @ApiOperation("根据订单ID获取订单")
    @GetMapping("/find/{id}")
    public OrderDto findOrder(@PathVariable Long id) {
        Order order = orderRepository.find(OrderId.of(id));
        return OrderDtoAssembler.INSTANCE.toDTO(order);
    }
}
