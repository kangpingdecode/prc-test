package com.kangping.user.V2;

import com.kangping.order.OrderService;
import com.kangping.order.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 功能：
 * </p>
 *
 * @author kangping
 * Copyright Inc. All rights reserved
 * @version v1.0
 * @ClassName: UserController
 * @date 2020/7/5
 */
@RestController
public class UserController {

    @KpAutowired
    private OrderService orderService;

    @KpAutowired
    private PayService payService;

    @GetMapping("/getOrder")
    public String getOrder() {
        return orderService.getOrder();
    }

    @GetMapping("/pay")
    public String pay() {
        return payService.pay();
    }


}
