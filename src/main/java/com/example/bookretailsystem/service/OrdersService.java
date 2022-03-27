package com.example.bookretailsystem.service;

import com.example.bookretailsystem.common.CommonResult;
import com.example.bookretailsystem.common.ResultCode;
import com.example.bookretailsystem.entity.Members;
import com.example.bookretailsystem.entity.Orders;
import com.example.bookretailsystem.entity.OrdersDetails;
import com.example.bookretailsystem.entity.Points;
import com.example.bookretailsystem.repository.*;
import com.example.bookretailsystem.tool.Calculation;
import com.example.bookretailsystem.tool.CoperMember;
import com.example.bookretailsystem.tool.GoldCardMember;
import com.example.bookretailsystem.tool.SilverCardMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wuqianqian
 * @date 2022/3/27
 */
@Service
public class OrdersService {

    @Autowired
    private MembersRepository membersRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private PointsRepository pointsRepository;

    @Autowired
    private OrdersDetailsRepository ordersDetailsRepository;


    @Transactional
    public CommonResult order(Orders orders){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(ResultCode.SUCCESS.code());
        if (orders != null && orders.getOrdersDetails() != null) {
            Date date = new Date();
            orders.setOrderTime(date);
            orders.setCreateTime(date);
            //1.订单下单
            Orders orders1 = ordersRepository.save(orders);
            //2.订单下单成功，减库存
            for (OrdersDetails details : orders.getOrdersDetails()){
                booksRepository.updateBooksCount(details.getBooksId(),details.getOrderCount());
                details.setOrdersId(orders1.getId());
                details.setCreateTime(date);
                ordersDetailsRepository.save(details);
            }
            //3.减库存后，新增积分
            //3.1 根据会员类型计算会员积分，添加积分
            Members members = membersRepository.getById(orders.getMembersId());
            Points points = new Points();
            points.setOrdersId(orders.getId());
            points.setCreateTime(date);
            points.setPoints(calPoints(members.getMemberType(),orders.getTotalPrice()));
            points.setStatue("Y");
            pointsRepository.save(points);
            //3.2 会员表更新积分
            membersRepository.updatePoints(members.getId(),points.getPoints());
            commonResult.setMsg("下单成功:订单id是:" + orders1.getId());
        } else {
            commonResult.setMsg("订单异常，下单失败");
            commonResult.setCode(ResultCode.FAIL.code());
        }
        return commonResult;
    }

    public int calPoints(String memberType, BigDecimal totalPrice){
        int points = 0;
        if("GOLD".equals(memberType)){
            Calculation calculation = new GoldCardMember();
            points = calculation.calculationInterface(totalPrice);
        }else if("SILVER".equals(memberType)){
            Calculation calculation = new SilverCardMember();
            points = calculation.calculationInterface(totalPrice);
        }else if("COPER".equals(memberType)){
            Calculation calculation = new CoperMember();
            points = calculation.calculationInterface(totalPrice);
        }
        return points;
    }
}
