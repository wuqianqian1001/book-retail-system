package com.example.bookretailsystem.tool;

import java.math.BigDecimal;

public  interface Calculation {
    //定义一个抽象方法计算逻辑
    public abstract int calculationInterface(BigDecimal totalPrice);
}
