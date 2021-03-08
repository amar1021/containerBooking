package com.maersk.containerBooking;

import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.http.MediaType;

import com.maersk.containerBooking.Model.AvailablB;
import com.maersk.containerBooking.Model.BookingR;
import com.maersk.containerBooking.Model.ContainerType;
import com.maersk.containerBooking.Model.RequestBooking;
import com.maersk.containerBooking.Model.ResponseBooking;
import com.maersk.containerBooking.Service.BookingService;
import com.maersk.containerBooking.controller.BookingController;

import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = BookingController.class)
@Import(BookingService.class)
public class BookingControllerTest {

	@MockBean
	BookingService bs;

	@Autowired
	private WebTestClient webClient;

	@Test
	void testGetAvailableBooking() {
		List<ResponseBooking> list = new ArrayList<ResponseBooking>();
		list.add(new ResponseBooking(5, ContainerType.DRY, "test", "test", 20));

		Mockito.when(bs.getAllBookings()).thenReturn(list);

		webClient.get().uri("/api/bookings/checkavailablebooking").exchange().expectStatus().isOk()
				.expectBodyList(ResponseBooking.class);

		Mockito.verify(bs, times(1)).getAllBookings();
	}

	@Test
	void testGetService() {
		AvailablB b = new AvailablB();
		b.setAvailable(true);

		Mockito.when(bs.availableBooking()).thenReturn(Mono.just(b));

		webClient.get().uri("/api/bookings/checkavailable").exchange().expectStatus().isOk()
				.expectBodyList(ResponseBooking.class);

		Mockito.verify(bs, times(1)).availableBooking();
	}

	@Test
	void testsaveBooking() {

		RequestBooking rb = new RequestBooking();
		rb.setContainerSize(5);
		rb.setContainerType(ContainerType.DRY);
		rb.setOrigin("test");
		rb.setDestination("Test");
		rb.setQuantity(5);
		rb.setTimestamp("2020-10-11T13:53:09Z");
		rb.setBookingRef(1);

		BookingR br = new BookingR();
		br.setBookingRef("957000001");

		Mockito.when(bs.saveBooking(rb)).thenReturn(Mono.just(br));

		webClient.post().uri("/api/bookings/savebookings").contentType(MediaType.APPLICATION_JSON)
				.body(Mono.just(rb), RequestBooking.class).exchange().expectStatus().isOk();
	}
}
