package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Review;
import cn.edu.shu.xj.ser.entity.Service;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.LinkedHashMap;
import java.util.List;

public interface IReviewService extends IService<Review> {
    public boolean giveReview(Integer sid, String uid, Integer oid, Integer sc, String ct);

    public boolean giveReviewWithoutContent(Integer sid, String uid, Integer oid, Integer sc);

    public boolean catchupContent(Integer rid, String ct);

    public List<Review> loadReviews(Integer sid);

    public List<LinkedHashMap<Review, Service>> loadReviewsAreaCategory(String sa, String ca);
}