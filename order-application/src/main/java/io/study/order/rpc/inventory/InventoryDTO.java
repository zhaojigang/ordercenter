package io.study.order.rpc.inventory;

import lombok.Data;

/**
 * 库存 DTO
 * @author jigang
 */
@Data
public class InventoryDTO {
    /**
     * 商品 ID
     */
    private Long goodsId;
    /**
     * 剩余库存
     */
    private Integer remainQuantity;
}
