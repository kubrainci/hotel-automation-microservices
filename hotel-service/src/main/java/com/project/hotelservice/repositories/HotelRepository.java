package com.project.hotelservice.repositories;

import com.project.hotelservice.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    void deleteByInvCode(String inventoryCode);

    Hotel getReferenceByInvCode(String inventoryCode);
}
