package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capg.entity.Bookingdetails;

@Repository
public interface BookingdetailsRepository extends JpaRepository<Bookingdetails, Integer> {

}
