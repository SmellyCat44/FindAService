package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Order;
import cn.edu.shu.xj.ser.mapper.OrderMapper;
import cn.edu.shu.xj.ser.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    OrderMapper orderMapper;

    public boolean userRequest(String uid, Integer sid, String dt, String da){
        return orderMapper.userRequest(uid,sid,dt,da);
    }

    public List<Order> requestList(String pid){
        return orderMapper.requestList(pid);
    }
}
