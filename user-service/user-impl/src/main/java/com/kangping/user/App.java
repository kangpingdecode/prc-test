package com.kangping.user;

import com.kangping.order.OrderService;
import com.sun.deploy.util.OrderedHashSet;

/**
 * <p>
 * 功能：
 * </p>
 *
 * @author kangping
 * Copyright Inc. All rights reserved
 * @version v1.0
 * @ClassName: App
 * @date 2020/6/28
 */

public class App {

    public static void main(String[] args) {
        OrderService orderService = RpcProxyClient.newInstance(OrderService.class,"localhost",8081);
        String order = orderService.getOrder();
        String orderlist = orderService.getOrderlist(1);
        System.out.println(order);
        System.out.println(orderlist);
    }
}
