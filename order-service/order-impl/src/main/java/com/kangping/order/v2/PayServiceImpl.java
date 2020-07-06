package com.kangping.order.v2;

import com.kangping.order.PayService;

/**
 * <p>
 * 功能：
 * </p>
 *
 * @author kangping
 * Copyright Inc. All rights reserved
 * @version v1.0
 * @ClassName: PayServiceImpl
 * @date 2020/7/5
 */
@KpService
public class PayServiceImpl implements PayService {

    public String pay() {
        return "EXECUTE PAY METHOD";
    }
}
