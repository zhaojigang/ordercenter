package io.study.order.data;

import org.apache.ibatis.annotations.Mapper;

/**
 * 订单 DAO
 */
@Mapper
public interface OrderDAO {
    int deleteByPrimaryKey(Long id);

    int insert(OrderDO record);

    int insertSelective(OrderDO record);

    OrderDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderDO record);

    int updateByPrimaryKey(OrderDO record);
}