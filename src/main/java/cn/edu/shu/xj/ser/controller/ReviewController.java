package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.entity.Order;
import cn.edu.shu.xj.ser.entity.Review;
import cn.edu.shu.xj.ser.service.IOrderService;
import cn.edu.shu.xj.ser.service.IReviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "ReviewInterface")
@RequestMapping("/review")
@RestController
@CrossOrigin("http://localhost:3000")
public class ReviewController {

    @Autowired
    IReviewService reviewService;

    @Autowired
    IOrderService orderService;

    //with content
    @ApiOperation(value = "user_give_review")
    @PostMapping("/user_give")
    public boolean giveReview(@RequestParam(value = "user_id")String uid, @RequestParam(value = "service_id")Integer sid, @RequestParam(value = "order_id")Integer oid, @RequestParam(value = "score")Integer sc, @RequestParam(value = "content")String ct){
        Order oneorder  = orderService.getById(oid);
        if(oneorder==null) return false;
        return reviewService.giveReview(sid,uid,oid,sc,ct);
    }

    //without content
    @ApiOperation(value = "user_give_review")
    @PostMapping("/user_give_without_content")
    public boolean giveReviewWithoutContent(@RequestParam(value = "user_id")String uid, @RequestParam(value = "service_id")Integer sid, @RequestParam(value = "order_id")Integer oid, @RequestParam(value = "score")Integer sc){
        Order oneorder  = orderService.getById(oid);
        if(oneorder==null) return false;
        return reviewService.giveReviewWithoutContent(sid,uid,oid,sc);
    }

    //catch up the content after score
    @ApiOperation(value = "user_catch_content")
    @PostMapping("/user_catch_content")
    public boolean catchupContent(@RequestParam(value = "review_id")Integer rid, @RequestParam(value = "content")String ct){
        Review oneReview = reviewService.getById(rid);
        if(oneReview==null) return false;
        return reviewService.catchupContent(rid,ct);
    }

    @ApiOperation(value = "admin_delete_review")
    @PostMapping("/admin_delete_review")
    public boolean adminDeleteReview(@RequestParam(value = "review_id")Integer rid){
        Review oneReview = reviewService.getById(rid);
        if(oneReview==null) return false;
        return reviewService.removeById(rid);
    }

    @ApiOperation(value = "load_reviews_to_one_specific_service")
    @PostMapping("/load_reviews")
    public List<Review> loadReviews(@RequestParam(value = "service_id")Integer sid){
        return reviewService.loadReviews(sid);
    }


}
