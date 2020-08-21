package com.pabloso18.hateoas.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pabloso18.hateoas.model.HotelReviewEntity;
import org.springframework.beans.BeanUtils;

/**
 * @author Jose_Solano
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelReviewVO extends BaseVO {

    private String id;
    private String review;
    private Integer score;
    private String hotelId;

    public HotelReviewVO(String review, Integer score) {
        this.review = review;
        this.score = score;
    }

    public HotelReviewVO(String review, Integer score, String hotelId) {
        this.review = review;
        this.score = score;
        this.hotelId = hotelId;
    }

    public HotelReviewVO(HotelReviewEntity entity) {
        BeanUtils.copyProperties(entity, this);
        this.hotelId = entity.getHotel().getId();
    }

    public HotelReviewVO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
}
