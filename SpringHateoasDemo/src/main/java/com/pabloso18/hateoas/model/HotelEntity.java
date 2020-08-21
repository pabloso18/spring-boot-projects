package com.pabloso18.hateoas.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Hotel Entity
 * @author Jose_Solano
 */
@Entity
@Table(name = "hotel")
public class HotelEntity extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "country", nullable = false)
    private String country;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "zipCode", nullable = false)
    private String zipCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel")
    private Set<HotelReviewEntity> hotelReviews;


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

    public Set<HotelReviewEntity> getHotelReviews() {
        return hotelReviews;
    }
    public void setHotelReviews(Set<HotelReviewEntity> hotelReviews) {
        this.hotelReviews = hotelReviews;
    }


}
