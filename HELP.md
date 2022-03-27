# 图书零售系统

### 需求
* 可以创建三种不同的会员类型 (Gold, Silver, Coper)
* 支持订购图书
* 会员积分的计算方式:
    * Gold member – 订单金额 * 3
    * Silver member – 订单金额 * 2
    * Coper member – 订单金额
* 可以查询订单 
* H2作为数据库

### 期望
* 实现3个RestAPIs
* 单元测试
* 集成测试
* 所有测试都通过
* 运行成功
* 使用设计模式
* 可维护性
* ...

### 技术
* springboot
* jpa
* 数据库 H2


### 注意事项
* 新增、修改、删除的校验
* 并发情况下订购图书
* 事务处理
* 订单创建到取消，业务闭环
* 异常统一返回

###数据表
* 图书商品表（ID，图书名称，图书数量，图书单价，创建时间，修改时间，图书状态）
* 会员表（ID，会员名称，会员号码，会员类型，有效性，创建时间，积分）
* 订单表（ID，会员ID，创建时间，订单时间，订单总金额，订单状态）
* 订单明细表（ID，订单ID，图书ID,创建时间，下单数量，下单总金额，订单明细状态）
* 积分表（ID，订单ID,创建时间，积分值，状态）

###测试
* 获取所有图书信息:http://localhost:8080/books/booksList
* 根据ID获取某一图书信息:http://localhost:8080/books/getById/1
* 根据会员号码获取订单信息:http://localhost:8080/orders/getByMemberNo/NO00001
* 下单测试:http://localhost:8080/orders/orderBooks
 {
  "membersId": "3",
  "totalPrice": "128.00",
  "orderStatue": "Y",
  "ordersDetails":[
  {
  "booksId":"2",
  "orderCount":"1",
  "totalPrice":"128.00",
  "orderDetailsStatue":"Y"
  }
  ]
  }