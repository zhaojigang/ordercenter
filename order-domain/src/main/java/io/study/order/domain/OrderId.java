package io.study.order.domain;

import lombok.Value;

/**
 * 订单ID
 *
 * @author jigang
 */
@Value
public class OrderId {
    private Long id;

    public static OrderId of(Long id) {
        return new OrderId(id);
    }
}
