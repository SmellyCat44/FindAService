package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("services")
public class Service {
    @TableId(value = "service_id",type = IdType.INPUT)
    private Integer serviceId;
    private String providerId;
    private String serviceDescription;
    private String servicePhoto;
    private Double price;
    private String serviceArea;
    private String availability;
    private String serviceCategory;
    private String providerEmail;
    private Double avgScore;
}
