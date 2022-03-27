package com.example.bookretailsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wuqianqian
 * @date 2022/3/27
 */

@Entity
@Table(name = "ORDERS_DETAILS")
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class OrdersDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Long ordersId;

    private Long booksId;

    private Date createTime;

    private Integer orderCount;

    private BigDecimal totalPrice;

    private String orderDetailsStatue;
}
