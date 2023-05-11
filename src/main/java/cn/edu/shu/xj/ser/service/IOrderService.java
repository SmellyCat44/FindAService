package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Admin;
import cn.edu.shu.xj.ser.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IOrderService extends IService<Order> {

    public boolean userRequest(String uid, Integer sid, String dt, String da);

    public List<Order> requestList(String pid);
}