package io.study.order.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 订单数据传输对象
 *
 * @author jigang
 */
@ApiModel("订单")
@Data
public class OrderDto {
    /**
     * 订单 ID
     */
    @ApiModelProperty("订单ID")
    private Long id;
    /**
     * 订单名称
     */
    @ApiModelProperty("订单名称")
    private String name;
}
