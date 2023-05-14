package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("serviceprovider")
public class Serviceprovider {
    @TableId(value = "provider_id",type = IdType.INPUT)
    private String providerId;
    private String providerPwd;
    private String providerAdd;
    private String description;
    private Integer verified;
    private Double avgScore;
}
