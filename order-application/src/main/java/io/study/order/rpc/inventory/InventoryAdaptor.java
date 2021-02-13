package io.study.order.rpc.inventory;

/**
 * 库存第三方服务接口
 *
 * @author jigang
 */
public interface InventoryAdaptor {
    /**
     * 获取商品剩余库存信息
     * @param goodsId
     * @return
     */
    InventoryDTO getRemainQuality(Long goodsId);

    /**
     * 扣减库存
     * @param goodsId
     * @param reduceQuality 减少的库存数
     * @return
     */
    Boolean reduceRemainQuality(Long goodsId, Integer reduceQuality);
}
