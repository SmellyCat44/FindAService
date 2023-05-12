package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.Admin;
import cn.edu.shu.xj.ser.entity.Review;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReviewMapper extends BaseMapper<Review> {

    @Insert("INSERT INTO review (service_id, user_id, order_id, score, content)\n" +
            "VALUES (#{service_id}, #{user_id}, #{order_id},#{score},#{content});")
    boolean giveReview(@Param("service_id")Integer sid, @Param("user_id")String uid, @Param("order_id")Integer oid,@Param("score") Integer sc, @Param("content")String ct);

    @Insert("INSERT INTO review (service_id, user_id, order_id, score)\n" +
            "VALUES (#{service_id}, #{user_id}, #{order_id},#{score});")
    boolean giveReviewWithoutContent(@Param("service_id")Integer sid, @Param("user_id")String uid, @Param("order_id")Integer oid,@Param("score") Integer sc);

    @Update("update review set content=#{content} where review_id=#{review_id}")
    boolean catchupContent(@Param("content")String rid, @Param("review_id")Integer ct);

    @Select("select * from review where service_id=#{service_id}")
    List<Review> loadReviews(@Param("service_id")Integer sid);
}