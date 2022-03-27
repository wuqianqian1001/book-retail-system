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
@Table(name = "BOOKS")
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookName;

    private Integer count;

    private BigDecimal unitPrice;

    private Date createTime;

    private Date modifyTime;

    private String enableFlag;

}
