package com.pabloso18.hateoas.service.impl;

import com.pabloso18.hateoas.exception.NotFoundException;
import com.pabloso18.hateoas.model.HotelEntity;
import com.pabloso18.hateoas.repository.HotelRepository;
import com.pabloso18.hateoas.service.HotelService;
import com.pabloso18.hateoas.vo.HotelVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Jose_Solano
 */
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public HotelVO create(HotelVO hotel) {
        HotelEntity entity = new HotelEntity();

        BeanUtils.copyProperties(hotel, entity);

        entity = hotelRepository.save(entity);

        return new HotelVO(entity);
    }

    @Override
    public List<HotelVO> findAllHotels() {

        List<HotelEntity> hotelEntities = hotelRepository.findAll();

        final List<HotelVO> voList = hotelEntities.stream().map(h -> new HotelVO(h)).collect(Collectors.toList());

        return voList;
    }

    @Override
    public HotelVO findHotelById(String id) throws NotFoundException {
        return new HotelVO(getHotelEntity(id));
    }

    @Override
    public void delete(String id) throws NotFoundException {
        hotelRepository.delete(getHotelEntity(id));
    }

    private HotelEntity getHotelEntity(String id) throws NotFoundException {

        Optional<HotelEntity> optionalHotelEntity = hotelRepository.findById(id);

        if(!optionalHotelEntity.isPresent()){
            throw new NotFoundException("Hotel with the ID: " + id + " not found");
        }

        return optionalHotelEntity.get();
    }
}
