package io.study.order.data;

import io.study.order.dto.OrderQueryRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单 DAO
 */
@Mapper
public interface OrderDAO {
    int insertSelective(OrderDO record);
    OrderDO selectByPrimaryKey(Long id);
    List<OrderDO> selectByCondition(OrderQueryRequest request);
}