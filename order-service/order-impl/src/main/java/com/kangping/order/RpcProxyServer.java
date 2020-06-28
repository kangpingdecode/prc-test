package com.kangping.order;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * 功能：
 * </p>
 *
 * @author kangping
 * Copyright Inc. All rights reserved
 * @version v1.0
 * @ClassName: RpcProxyServer
 * @date 2020/6/28
 */

public class RpcProxyServer {

    public static ExecutorService executorService = Executors.newFixedThreadPool(20);


    public void publierServer(Object server, int port) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                socket = serverSocket.accept();
                executorService.submit(new SocketRunnable(socket,server));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null)
                    serverSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }



}
