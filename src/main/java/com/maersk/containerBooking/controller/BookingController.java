package com.maersk.containerBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maersk.containerBooking.Model.AvailablB;
import com.maersk.containerBooking.Model.BookingR;
import com.maersk.containerBooking.Model.RequestBooking;
import com.maersk.containerBooking.Model.ResponseBooking;
import com.maersk.containerBooking.Service.BookingService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

	@Autowired
	BookingService bs;

	@GetMapping("/checkavailablebooking")
	public List<ResponseBooking> getAvailableBooking() {
		return bs.getAllBookings();
	}

	@GetMapping("/checkavailable")
	public Mono<AvailablB> getService() {
		return bs.availableBooking();
	}

	@PostMapping("/savebookings")
	public Mono<BookingR> saveBooking(@RequestBody RequestBooking booking) {
		return bs.saveBooking(booking);
	}
}
