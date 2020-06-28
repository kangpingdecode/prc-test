package com.kangping.order;

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
        OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
        RpcProxyServer proxyServer = new RpcProxyServer();
        proxyServer.publierServer(orderServiceImpl,8081);
    }
}
