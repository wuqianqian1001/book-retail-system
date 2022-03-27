package com.example.bookretailsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wuqianqian
 * @date 2022/3/27
 */

@Entity
@Table(name = "POINTS")
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Points {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ordersId;

    private Integer points;

    private Date createTime;

    private String statue;
}
