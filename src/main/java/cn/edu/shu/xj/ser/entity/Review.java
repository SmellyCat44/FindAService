package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("review")
public class Review {
    @TableId(value = "review_id",type = IdType.INPUT)
    private Integer reviewId;
    private Integer orderId;
    private Integer serviceId;
    private String userId;
    private Integer score;
    private String content;
}
