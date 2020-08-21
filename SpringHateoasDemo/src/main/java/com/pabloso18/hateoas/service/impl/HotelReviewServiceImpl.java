package com.pabloso18.hateoas.service.impl;

import com.pabloso18.hateoas.exception.NotFoundException;
import com.pabloso18.hateoas.model.HotelEntity;
import com.pabloso18.hateoas.model.HotelReviewEntity;
import com.pabloso18.hateoas.repository.HotelRepository;
import com.pabloso18.hateoas.repository.HotelReviewRepository;
import com.pabloso18.hateoas.service.HotelReviewService;
import com.pabloso18.hateoas.vo.HotelReviewVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Jose_Solano
 */
@Service
public class HotelReviewServiceImpl implements HotelReviewService {

    @Autowired
    private HotelReviewRepository hotelReviewRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public HotelReviewVO getReviewById(String id) throws NotFoundException {
        return new HotelReviewVO(getHotelReviewEntity(id));
    }

    @Override
    public HotelReviewVO create(HotelReviewVO review) throws NotFoundException {
        HotelReviewEntity entity = new HotelReviewEntity();

        Optional<HotelEntity> hotelEntity = hotelRepository.findById(review.getHotelId());

        if(!hotelEntity.isPresent()){
            throw new NotFoundException("Hotel with the ID: " + review.getHotelId() + " not found");
        }

        BeanUtils.copyProperties(review, entity);
        entity.setHotel(hotelEntity.get());

        entity = hotelReviewRepository.save(entity);

        return new HotelReviewVO(entity);
    }

    @Override
    public void delete(String id) throws NotFoundException {
        hotelReviewRepository.delete(getHotelReviewEntity(id));
    }

    private HotelReviewEntity getHotelReviewEntity(String id) throws NotFoundException {
        Optional<HotelReviewEntity> optionalHotelReview = hotelReviewRepository.findById(id);

        if(!optionalHotelReview.isPresent()){
            throw new NotFoundException("Hotel Review with the ID: " + id + " not found");
        }

        return optionalHotelReview.get();
    }
}
