package com.kangping.order;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>
 * 功能：
 * </p>
 *
 * @author kangping
 * Copyright Inc. All rights reserved
 * @version v1.0
 * @ClassName: SocketRunable
 * @date 2020/6/28
 */

public class SocketRunnable implements Runnable {

    private Socket socket;

    private Object server;

    public SocketRunnable(Socket socket,Object server) {
        this.socket = socket;
        this.server = server;
    }

    public void run() {


        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest rpcRequest = (RpcRequest) objectInputStream.readObject();
            Object object = invoke(rpcRequest, server);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(object);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null)
                    socket.close();
                if (objectInputStream != null)
                    objectInputStream.close();
                if (objectOutputStream != null)
                    objectOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public Object invoke(RpcRequest request, Object server) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class<?> aClass = Class.forName(request.getClassName());
        Method method = aClass.getMethod(request.getMethodName(), request.getTypes());
        Object invoke = method.invoke(server, request.getParameters());
        return invoke;
    }

}
