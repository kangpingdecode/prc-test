package com.kangping.user.V2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * <p>
 * 功能：
 * </p>
 *
 * @author kangping
 * Copyright Inc. All rights reserved
 * @version v1.0
 * @ClassName: InitialProxy
 * @date 2020/7/5
 */
@Component
public class InitialProxy implements BeanPostProcessor {

    @Value("${kp.host}")
    private String host;

    @Value("${kp.port}")
    private int port;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].isAnnotationPresent(KpAutowired.class)) {
                fields[i].setAccessible(true);
                Object proxy = RpcProxyClient.newInstance(fields[i].getType(), host, port);
                try {
                    fields[i].set(bean, proxy);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }
        return bean;
    }
}
