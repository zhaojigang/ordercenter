package io.study.order.domain;

import common.exception.OrderException;
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

    public void validId(){
        if (id == null || id <= 0) {
            throw new OrderException(400, "id 为空");
        }
    }
}
