package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("orders")
public class Order {
    @TableId(value = "order_id",type = IdType.INPUT)
    private Integer orderId;
    private Integer serviceId;
    private String userId;
    private Integer reviewId;
    private Timestamp orderTime;
    //pending, rejected, accepted, completed
    private String orderStatus;
    private String detailTime;
    private String detailAdd;
    private String orderDetail1;
    private String orderDetail2;
    private String orderDetail3;
    private String orderDetail4;
}
