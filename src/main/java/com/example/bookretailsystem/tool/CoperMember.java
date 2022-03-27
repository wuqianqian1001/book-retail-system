package com.example.bookretailsystem.tool;

import java.math.BigDecimal;

public class CoperMember implements Calculation{
    /**
     *Coper会员 – 订单总价
     */
    @Override
    public int calculationInterface(BigDecimal totalPrice) {
        return totalPrice.intValue();
    }
}
