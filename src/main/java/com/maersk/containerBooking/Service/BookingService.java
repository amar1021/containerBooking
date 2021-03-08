package com.maersk.containerBooking.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.maersk.containerBooking.Model.AvailablB;
import com.maersk.containerBooking.Model.AvailablS;
import com.maersk.containerBooking.Model.BookingR;
import com.maersk.containerBooking.Model.RequestBooking;
import com.maersk.containerBooking.Model.ResponseBooking;
import com.maersk.containerBooking.repository.BookingRepository;

import reactor.core.publisher.Mono;

@Service
public class BookingService {

	@Autowired
	BookingRepository br;
	WebClient webClient = WebClient.create("http://localhost:8484/api/bookings");

	public List<ResponseBooking> getAllBookings() {
		AvailablB ab = getBooking().block();
		if (ab.getAvailable()) {
			List<ResponseBooking> bookings = new ArrayList<ResponseBooking>();
			br.findAll().forEach(i -> {
				bookings.add(new ResponseBooking(i.getContainerSize(), i.getContainerType(), i.getOrigin(),
						i.getDestination(), i.getQuantity()));
			});
			return bookings;
		}
		return null;
	}

	public Mono<AvailablB> getBooking() {
		return webClient.get().uri("/checkavailable").retrieve().bodyToMono(AvailablB.class);
	}

	public Mono<AvailablS> checkAvailable() {
		// return
		// WebClient.create("https://maersk.com/api/bookings/checkAvailable").get().retrieve().bodyToMono(AvailablS.class);
		AvailablS av = new AvailablS();
		av.setAvailablSpace(6);
		return Mono.just(av);
	}

	public Mono<AvailablB> availableBooking() {
		AvailablB b = new AvailablB();
		if (checkAvailable().block().getAvailablSpace() > 0) {
			b.setAvailable(true);
			return Mono.just(b);
		} else {
			b.setAvailable(false);
			return Mono.just(b);
		}

	}

	public Mono<BookingR> saveBooking(RequestBooking b) {
		RequestBooking r = br.save(b);
		BookingR br = new BookingR();
		br.setBookingRef(String.valueOf(r.getBookingRef()));
		return Mono.just(br);
	}
}
