package io.study.order.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDTO implements Serializable {
    private static final long serialVersionUID = 8642623148247246765L;
    /**
     * 订单ID
     */
    private Long id;
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
}
