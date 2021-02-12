package io.study.order.data;

import lombok.Data;

/**
 * 订单数据库对象
 *
 * @author jigang
 */
@Data
public class OrderDO {
    /**
     * 订单 ID
     */
    private Long id;
    /**
     * 订单名称
     */
    private String name;
}