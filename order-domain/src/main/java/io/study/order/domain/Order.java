package io.study.order.domain;

import common.ddd.AggregateRoot;
import common.exception.OrderException;
import io.study.order.repository.OrderRepository;
import lombok.Getter;
import lombok.Setter;

/**
 * 订单聚合根
 *
 * @author jigang
 */
@Setter
@Getter
@AggregateRoot
public class Order {
    /**
     * 订单 ID
     */
    private OrderId id;
    /**
     * 订单名称
     */
    private String name;
    /**
     * 商品ID
     */
    private Long goodsId;
    /**
     * 购买数量
     */
    private Integer buyQuality;
    /**
     * 订单仓储
     */
    private OrderRepository orderRepository;

    protected Order(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * 创建订单
     *
     * @param order
     */
    public void saveOrder(Order order) {
        orderRepository.add(order);
    }

    public void setName(String name) {
        if (name == null) {
            throw new OrderException(400, "name 不能为空");
        }
        this.name = name;
    }

    public void setGoodsId(Long goodsId) {
        if (goodsId == null) {
            throw new OrderException(400, "goodsId 不能为空");
        }
        this.goodsId = goodsId;
    }

    public void setBuyQuality(Integer buyQuality) {
        if (buyQuality == null) {
            throw new OrderException(400, "buyQuality 不能为空");
        }
        this.buyQuality = buyQuality;
    }
}
