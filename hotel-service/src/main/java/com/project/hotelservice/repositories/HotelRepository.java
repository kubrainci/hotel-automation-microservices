package com.project.hotelservice.repositories;

import com.project.hotelservice.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    List<Hotel>findAll();

    Hotel getReferenceByInventoryCode(String inventoryCode);


    @Query(value = "SELECT * FROM hotel  WHERE  daily_price =:dailyPrice%",nativeQuery = true)
    List<Hotel>searchDailyPrice(double dailyPrice);

    @Query(value = "SELECT * FROM hotel  WHERE  hotel_name =:hotelName%",nativeQuery = true)
    List<Hotel>searchHotelName(String hotelName);

    @Query(value = "SELECT * FROM hotel  WHERE  country =:country%",nativeQuery = true)
    List<Hotel>searchCountry(String country);

    @Query(value = "SELECT * FROM hotel  WHERE  star =:star%",nativeQuery = true)
    List<Hotel>searchStar(String star);

    @Query(value = "SELECT * FROM hotel order by daily_price ASC",nativeQuery = true)
    List<Hotel>searchFromSmallToBig(double dailyPrice);

    @Query(value = "SELECT * FROM hotel  order by  hotel_name ASC",nativeQuery = true)
    List<Hotel>searchAZHotelName(String hotelName);

    @Query(value = "SELECT * FROM hotel  order by  country ASC",nativeQuery = true)
    List<Hotel>searchAZCountry(String country);

    @Query(value = "SELECT * FROM hotel order by star DESC",nativeQuery = true)
    List<Hotel>searchFromBigToSmall(int star);
}
