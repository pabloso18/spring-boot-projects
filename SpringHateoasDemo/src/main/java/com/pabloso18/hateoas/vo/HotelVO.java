package com.pabloso18.hateoas.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pabloso18.hateoas.model.HotelEntity;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jose_Solano
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelVO extends BaseVO {

    private static final long serialVersionUID = -3263937513550319094L;

    private String id;
    private String name;
    private String country;
    private String address;
    private String phone;
    private String zipCode;

    private List<HotelReviewVO> reviews;

    public HotelVO(String id) {
        this.id = id;
    }

    public HotelVO(String id, String name, String country, String address, String phone, String zipCode) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.address = address;
        this.phone = phone;
        this.zipCode = zipCode;
    }

    public HotelVO(HotelEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if(CollectionUtils.isNotEmpty(entity.getHotelReviews())){
            List<HotelReviewVO> reviewList = entity.getHotelReviews().stream()
                    .map(r -> new HotelReviewVO(r)).collect(Collectors.toList());
            this.reviews = new ArrayList<>(reviewList);
        }
    }

    public HotelVO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public List<HotelReviewVO> getReviews() {
        return reviews;
    }
    public void setReviews(List<HotelReviewVO> reviews) {
        this.reviews = reviews;
    }
}
