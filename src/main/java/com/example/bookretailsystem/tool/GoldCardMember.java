package com.example.bookretailsystem.tool;

import java.math.BigDecimal;

public class GoldCardMember implements Calculation {
    /**
     *金卡会员 – 订单总价 * 3
     */
    @Override
   public int calculationInterface(BigDecimal totalPrice) {
        BigDecimal baseBig = new BigDecimal(3);
        BigDecimal totalIntegral = totalPrice.multiply(baseBig);
        return totalIntegral.intValue();
    }
}
