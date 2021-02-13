package io.study.order.rpc.impl;

import io.study.inventory.dto.InventoryInfoDTO;
import io.study.inventory.facade.InventoryFacade;
import io.study.order.rpc.inventory.InventoryAdaptor;
import io.study.order.rpc.inventory.InventoryDTO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

/**
 * 库存服务（Dubbo 实现）
 *
 * @author jigang
 */
@Component("dubboInventoryAdaptor")
public class DubboInventoryAdaptorImpl implements InventoryAdaptor {
    @DubboReference(version = "1.0.0", group = "product")
    private InventoryFacade inventoryFacade;

    @Override
    public InventoryDTO getRemainQuality(Long goodsId) {
        InventoryInfoDTO inventoryInfoDTO = inventoryFacade.getRemainQuality(goodsId);
        return DubboInventoryTranslator.INSTANCE.toInventoryDTO(inventoryInfoDTO);
    }

    @Override
    public Boolean reduceRemainQuality(Long goodsId, Integer reduceQuality) {
        return inventoryFacade.reduceRemainQuality(goodsId, reduceQuality);
    }
}
