package com.pabloso18.hateoas.service;

import com.pabloso18.hateoas.exception.NotFoundException;
import com.pabloso18.hateoas.model.HotelReviewEntity;
import com.pabloso18.hateoas.vo.HotelReviewVO;

/**
 * @author Jose_Solano
 */
public interface HotelReviewService {

    HotelReviewVO getReviewById(String id) throws NotFoundException;

    HotelReviewVO create(HotelReviewVO review) throws NotFoundException;

    void delete(String id) throws NotFoundException;

}
