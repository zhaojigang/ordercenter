package io.study.order.facade;

import io.study.order.dto.OrderDTO;
import io.study.order.dto.OrderQueryRequest;

import java.util.List;

/**
 * 订单服务
 *
 * @author jigang
 */
public interface OrderFacade {
    /**
     * 查询订单
     *
     * @param request
     * @return
     */
    List<OrderDTO> getOrderList(OrderQueryRequest request);

    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    void createOrder(OrderDTO orderDTO);
}
