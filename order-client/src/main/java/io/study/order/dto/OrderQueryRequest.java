package io.study.order.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * order 查询请求参数
 *
 * @author jigang
 */
@Data
public class OrderQueryRequest implements Serializable {
    private static final long serialVersionUID = 3330101115728844788L;
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 订单名称
     */
    private String orderName;
}
