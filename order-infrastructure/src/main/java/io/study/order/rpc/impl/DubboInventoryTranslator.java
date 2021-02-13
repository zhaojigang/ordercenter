package io.study.order.rpc.impl;

import io.study.inventory.dto.InventoryInfoDTO;
import io.study.order.rpc.inventory.InventoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 库存服务防腐对象转换器
 *
 * @author jigang
 */
@Mapper
public interface DubboInventoryTranslator {
    DubboInventoryTranslator INSTANCE = Mappers.getMapper(DubboInventoryTranslator.class);

    InventoryDTO toInventoryDTO(InventoryInfoDTO inventoryInfoDTO);
}
