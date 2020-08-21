package com.pabloso18.hateoas.service;

import com.pabloso18.hateoas.exception.NotFoundException;
import com.pabloso18.hateoas.vo.HotelVO;

import java.util.List;

/**
 * @author Jose_Solano
 */
public interface HotelService {

    HotelVO create(HotelVO hotel);

    void delete(String id) throws NotFoundException;

    List<HotelVO> findAllHotels();

    HotelVO findHotelById(String id) throws NotFoundException;

}
