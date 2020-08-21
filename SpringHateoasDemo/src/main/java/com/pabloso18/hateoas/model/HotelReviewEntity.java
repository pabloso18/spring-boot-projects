package com.pabloso18.hateoas.model;

import javax.persistence.*;

/**
 * Hotel Review Entity
 * @author Jose_Solano
 */
@Entity
@Table(name = "hotel_review")
public class HotelReviewEntity extends BaseEntity {

    @Column(name = "review", nullable = false)
    private String review;

    @Column(name = "score", nullable = false)
    private Integer score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    private HotelEntity hotel;

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

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }
}
