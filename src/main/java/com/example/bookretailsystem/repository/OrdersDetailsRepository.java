package com.example.bookretailsystem.repository;

import com.example.bookretailsystem.entity.OrdersDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wuqianqian
 * @date 2022/3/27
 */
@Repository
public interface OrdersDetailsRepository extends JpaRepository<OrdersDetails,Long> {
}
