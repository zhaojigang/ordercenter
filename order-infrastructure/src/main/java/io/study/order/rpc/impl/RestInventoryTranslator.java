package io.study.order.rpc.impl;

import com.alibaba.fastjson.JSON;
import io.study.order.rpc.inventory.InventoryDTO;

/**
 * 库存服务类型转换器（Rest）
 *
 * @author jigang
 */
public class RestInventoryTranslator {
    public static InventoryDTO translateRestResponse2InventoryDTO(String restResponse){
        return JSON.parseObject(restResponse, InventoryDTO.class);
    }

    public static Boolean translateRestResponse2Boolean(String restResponse){
        return JSON.parseObject(restResponse, Boolean.class);
    }
}
