package com.pabloso18.hateoas.controller;

import com.pabloso18.hateoas.exception.NotFoundException;
import com.pabloso18.hateoas.service.HotelService;
import com.pabloso18.hateoas.vo.HotelReviewVO;
import com.pabloso18.hateoas.vo.HotelVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author Jose_Solano
 */
@RestController
@RequestMapping(value = "/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping(value = "/v1/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getHotels() throws NotFoundException {

        List<HotelVO> voList = hotelService.findAllHotels();

        for (final HotelVO hotel : voList) {
            hotel.add(linkTo(methodOn(HotelController.class).getHotelById(hotel.getId())).withSelfRel());
            hotel.add(linkTo(methodOn(HotelController.class).delete(hotel.getId())).withRel("Delete"));

            if(CollectionUtils.isNotEmpty(hotel.getReviews())){
                for(HotelReviewVO review : hotel.getReviews()){
                    review.add(linkTo(methodOn(HotelReviewController.class).getReviewById(review.getId())).withSelfRel());
                    review.add(linkTo(methodOn(HotelReviewController.class).delete(review.getId())).withRel("Delete"));
                }
            }

        }

        return new ResponseEntity<>(voList, HttpStatus.OK);
    }


    @GetMapping(value = "/v1/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getHotelById(@PathVariable("id") String id) throws NotFoundException {

        HotelVO hotel = hotelService.findHotelById(id);

        hotel.add(linkTo(methodOn(HotelController.class).getHotelById(hotel.getId())).withSelfRel());
        hotel.add(linkTo(methodOn(HotelController.class).delete(hotel.getId())).withRel("Delete"));
        hotel.add(linkTo(methodOn(HotelController.class).getHotels()).withSelfRel());

        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @PostMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody HotelVO hotel) throws NotFoundException {

        HotelVO result = hotelService.create(hotel);

        result.add(linkTo(methodOn(HotelController.class).getHotelById(result.getId())).withSelfRel());
        result.add(linkTo(methodOn(HotelController.class).delete(result.getId())).withRel("Delete"));

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/v1/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) throws NotFoundException {

        hotelService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
