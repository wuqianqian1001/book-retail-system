package com.example.bookretailsystem.control;

import com.example.bookretailsystem.common.CommonResult;
import com.example.bookretailsystem.common.DateResult;
import com.example.bookretailsystem.common.ResultCode;
import com.example.bookretailsystem.entity.Orders;
import com.example.bookretailsystem.entity.OrdersDetails;
import com.example.bookretailsystem.repository.BooksRepository;
import com.example.bookretailsystem.repository.MembersRepository;
import com.example.bookretailsystem.repository.OrdersRepository;
import com.example.bookretailsystem.repository.PointsRepository;
import com.example.bookretailsystem.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wuqianqian
 * @date 2022-03-27
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private PointsRepository pointsRepository;

    @Autowired
    private MembersRepository membersRepository;

    @Autowired
    private OrdersService ordersService;


    @RequestMapping("/ordersList")
    public DateResult<List> list() {
        List<Orders> ordersList = ordersRepository.findAll();
        DateResult<List> dateResult = new DateResult<List>();
        dateResult.setCode(ResultCode.SUCCESS.code());
        dateResult.setMsg("查询成功");
        dateResult.setData(ordersList);
        return dateResult;
    }

    @GetMapping("/getById/{id}")
    public DateResult<Orders> getById(@PathVariable("id") Long id) {
        Orders orders = ordersRepository.getById(id);
        DateResult<Orders> ordersDateResult = new DateResult<Orders>();
        ordersDateResult.setCode(ResultCode.SUCCESS.code());
        ordersDateResult.setMsg("查询成功");
        ordersDateResult.setData(orders);
        return ordersDateResult;
    }

    @GetMapping("/getDetailsByOrdersId/{ordersId}")
    public DateResult<List> getDetailsByOrdersId(@PathVariable("ordersId") Long ordersId) {
        List<OrdersDetails> ordersDetailsList = ordersRepository.getDetailsByOrdersId(ordersId);
        DateResult<List> result = new DateResult<List>();
        result.setCode(ResultCode.SUCCESS.code());
        result.setMsg("查询成功");
        result.setData(ordersDetailsList);
        return result;
    }

    @GetMapping("/getByMemberNo/{memberNo}")
    public DateResult<List> getByMemberNo(@PathVariable("memberNo") String memberNo) {
        List<Orders> ordersList = ordersRepository.getByMemberNo(memberNo);
        DateResult<List> result = new DateResult<List>();
        result.setCode(ResultCode.SUCCESS.code());
        result.setMsg("查询成功");
        result.setData(ordersList);
        return result;
    }

    @PostMapping("/orderBooks")
    @Transactional
    public CommonResult orderBooks(@RequestBody Orders orders) {
        CommonResult commonResult = ordersService.order(orders);
        return commonResult;
    }


}
