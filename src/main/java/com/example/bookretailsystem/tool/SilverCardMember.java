package com.example.bookretailsystem.tool;

import java.math.BigDecimal;

public class SilverCardMember implements Calculation{
    /**
     *银卡会员 – 订单总价 * 2
     */
    @Override
    public int calculationInterface(BigDecimal totalPrice) {
        BigDecimal baseBig = new BigDecimal(2);
        BigDecimal totalIntegral = totalPrice.multiply(baseBig);
        return totalIntegral.intValue();
    }
}
