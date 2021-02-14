package io.study.order.rpc.impl;

import common.exception.OrderException;
import io.study.order.rpc.inventory.InventoryAdaptor;
import io.study.order.rpc.inventory.InventoryDTO;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 库存服务（Rest 实现）
 *
 * @author jigang
 */
@Component("restInventoryAdaptor")
public class RestInventoryAdaptorImpl implements InventoryAdaptor {
    private static final CloseableHttpClient HTTP_CLIENT = HttpClientBuilder.create().build();

    @Override
    public InventoryDTO getRemainQuality(Long goodsId) {
        HttpGet httpGet = new HttpGet("http://localhost:8082/inventory/getInventoryInfo?goodsId=" + goodsId);
        try {
            CloseableHttpResponse response = HTTP_CLIENT.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return RestInventoryTranslator.translateRestResponse2InventoryDTO(EntityUtils.toString(response.getEntity()));
            }
        } catch (IOException e) {
            throw new OrderException(500, "调用库存服务异常, e:" + e);
        }
        return null;
    }

    @Override
    public Boolean reduceRemainQuality(Long goodsId, Integer reduceQuality) {
        HttpPost httpPost = new HttpPost("http://localhost:8082/inventory/reduceRemainInventory?goodsId=" + goodsId + "&reduceQuality=" + reduceQuality);
        try {
            CloseableHttpResponse response = HTTP_CLIENT.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return RestInventoryTranslator.translateRestResponse2Boolean(EntityUtils.toString(response.getEntity()));
            }
        } catch (IOException e) {
            throw new OrderException(500, "调用库存服务异常, e:" + e);
        }
        return null;
    }
}
