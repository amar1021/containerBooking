package com.maersk.containerBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maersk.containerBooking.Model.RequestBooking;


public interface BookingRepository extends JpaRepository<RequestBooking, String>{

}
