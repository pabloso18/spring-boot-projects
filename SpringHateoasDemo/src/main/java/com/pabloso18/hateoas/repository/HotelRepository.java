package com.pabloso18.hateoas.repository;

import com.pabloso18.hateoas.model.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jose_Solano
 */
@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, String> {




}
