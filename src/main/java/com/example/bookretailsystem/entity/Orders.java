package com.example.bookretailsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author wuqianqian
 * @date 2022/3/27
 */

@Entity
@Table(name = "ORDERS")
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long membersId;

    private Date createTime;

    private Date orderTime;

    private BigDecimal totalPrice;

    private String orderStatue;

    @Transient
    private List<OrdersDetails> ordersDetails;

}
