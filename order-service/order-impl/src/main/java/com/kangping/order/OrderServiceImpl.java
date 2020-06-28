package com.kangping.order;

/**
 * <p>
 * 功能：
 * </p>
 *
 * @author kangping
 * Copyright Inc. All rights reserved
 * @version v1.0
 * @ClassName: OrderServiceImpl
 * @date 2020/6/28
 */

public class OrderServiceImpl implements OrderService {

    public String getOrder() {
        return "EXECUTE GET_ORDER METHOD";
    }

    public String getOrderlist(Integer id) {
        return "EXECUTE GET_ORDER_LIST METHOD"+id;
    }
}
