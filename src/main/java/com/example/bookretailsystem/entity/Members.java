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
@Table(name = "MEMBERS")
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberName;

    private String memberNo;

    private String memberType;

    private Date createTime;

    private Integer points;

    private String enableFlag;



}
