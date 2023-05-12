package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Admin;
import cn.edu.shu.xj.ser.entity.Review;
import cn.edu.shu.xj.ser.mapper.AdminMapper;
import cn.edu.shu.xj.ser.mapper.ReviewMapper;
import cn.edu.shu.xj.ser.service.IAdminService;
import cn.edu.shu.xj.ser.service.IReviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService extends ServiceImpl<ReviewMapper, Review> implements IReviewService {

    @Autowired
    ReviewMapper reviewMapper;

    public boolean giveReview(Integer sid, String uid, Integer oid, Integer sc, String ct){
        return reviewMapper.giveReview(sid,uid,oid,sc,ct);
    }

    public boolean giveReviewWithoutContent(Integer sid, String uid, Integer oid, Integer sc){
        return reviewMapper.giveReviewWithoutContent(sid,uid,oid,sc);
    }

    public boolean catchupContent(Integer rid, String ct){
        return reviewMapper.catchupContent(ct, rid);
    }

    public List<Review> loadReviews(Integer sid){
        return reviewMapper.loadReviews(sid);
    }


}
