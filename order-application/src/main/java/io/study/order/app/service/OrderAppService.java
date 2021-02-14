package io.study.order.app.service;

import common.exception.OrderException;
import io.study.order.domain.Order;
import io.study.order.rpc.inventory.InventoryAdaptor;
import io.study.order.rpc.inventory.InventoryDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 订单应用服务
 *
 * @author jigang
 */
@Service
public class OrderAppService {
//    @Resource(name = "dubboInventoryAdaptor")
    private InventoryAdaptor inventoryAdaptor;

    /**
     * 创建一个订单
     *
     * @param order
     */
    public void createOrder(Order order) {
        /**
         * 获取商品库存信息，进行校验
         */
//        InventoryDTO inventoryDTO = inventoryAdaptor.getRemainQuality(order.getGoodsId());
//        if (inventoryDTO.getRemainQuantity() - order.getBuyQuality() < 0) {
//            throw new OrderException(400, "商品库存不足");
//        }

        /**
         * 扣减库存
         */
//        inventoryAdaptor.reduceRemainQuality(order.getGoodsId(), order.getBuyQuality());

        /**
         * 存储订单
         */
        order.saveOrder(order);
    }
}
