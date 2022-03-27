package com.example.bookretailsystem.repository;

import com.example.bookretailsystem.entity.Orders;
import com.example.bookretailsystem.entity.OrdersDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wuqianqian
 * @date 2022/3/27
 */
@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long> {

    @Query("select o from Orders o left join Members m on o.membersId=m.id where m.memberNo =?1")
    public List<Orders> getByMemberNo(String memberNo);

    @Query("select od from Orders o left join OrdersDetails od on o.id =od.ordersId where o.id = ?1")
    public List<OrdersDetails> getDetailsByOrdersId(Long id);



}
