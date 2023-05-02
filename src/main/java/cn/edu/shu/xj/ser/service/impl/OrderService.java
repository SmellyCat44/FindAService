package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Order;
import cn.edu.shu.xj.ser.mapper.OrderMapper;
import cn.edu.shu.xj.ser.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    OrderMapper orderMapper;

}
