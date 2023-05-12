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
    private Integer order_id;
    private Integer service_id;
    private Integer user_id;
    private Timestamp order_time;
    private Integer order_status;
    private String detail_time;
    private String detail_add;
    private String order_detail1;
    private String order_detail2;
    private String order_detail3;
    private String order_detail4;
    private String providerId;
    private String serviceDescription;
    private String servicePhoto;
    private Double price;
    private String serviceArea;
    private String availability;
    private String serviceCategory;
    private String providerEmail;
}
