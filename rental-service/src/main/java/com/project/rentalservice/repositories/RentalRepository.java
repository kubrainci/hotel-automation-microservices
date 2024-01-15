package com.project.rentalservice.repositories;

import com.project.rentalservice.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,Integer> {

}
