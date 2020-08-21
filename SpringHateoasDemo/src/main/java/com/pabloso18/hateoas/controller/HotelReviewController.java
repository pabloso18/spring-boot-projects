package com.pabloso18.hateoas.controller;

import com.pabloso18.hateoas.exception.NotFoundException;
import com.pabloso18.hateoas.service.HotelReviewService;
import com.pabloso18.hateoas.vo.HotelReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author Jose_Solano
 */
@RestController
@RequestMapping(value = "/reviews")
public class HotelReviewController {

    @Autowired
    private HotelReviewService hotelReviewService;


    @GetMapping(value = "/v1/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelReviewVO> getReviewById(@PathVariable("id") String id) throws NotFoundException {

        final HotelReviewVO review = hotelReviewService.getReviewById(id);

        review.add(linkTo(methodOn(HotelReviewController.class).getReviewById(review.getId())).withSelfRel());
        review.add(linkTo(methodOn(HotelReviewController.class).delete(review.getId())).withRel("Delete"));
        review.add(linkTo(methodOn(HotelController.class).getHotelById(review.getHotelId())).withRel("hotel"));

        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PostMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody HotelReviewVO review) throws NotFoundException {

        HotelReviewVO result = hotelReviewService.create(review);

        result.add(linkTo(methodOn(HotelReviewController.class).getReviewById(result.getId())).withSelfRel());
        result.add(linkTo(methodOn(HotelReviewController.class).delete(result.getId())).withRel("Delete"));

        review.add(linkTo(methodOn(HotelController.class).getHotelById(result.getHotelId())).withRel("hotel"));

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/v1/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) throws NotFoundException {

        hotelReviewService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
