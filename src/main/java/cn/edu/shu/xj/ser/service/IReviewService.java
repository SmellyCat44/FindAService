package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Review;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IReviewService extends IService<Review> {
    public boolean giveReview(Integer sid, String uid, Integer oid, Integer sc, String ct);

    public boolean giveReviewWithoutContent(Integer sid, String uid, Integer oid, Integer sc);

    public boolean catchupContent(Integer rid, String ct);

    public List<Review> loadReviews(Integer sid);
}