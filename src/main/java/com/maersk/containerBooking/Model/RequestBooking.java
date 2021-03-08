package com.maersk.containerBooking.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name ="bookings")
public class RequestBooking {
	
	@Id
	@Column(name = "booking_ref")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingref;
	@Column(name = "container_size")
	private int containersize;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "container_type")
	private ContainerType containertype = ContainerType.DRY;
	
	private String origin;
	private String destination;
	private int quantity;
	private String timestamp;
	
	public RequestBooking() {}
	public RequestBooking(int containerSize, ContainerType containerType, String origin, String destination,
			int quantity) {
		super();
		this.containersize = containerSize;
		this.containertype = containerType;
		this.origin = origin;
		this.destination = destination;
		this.quantity = quantity;
	}
	
	public int getBookingRef() {
		return bookingref;
	}
	public void setBookingRef(int bookingRef) {
		this.bookingref = bookingRef;
	}
	public int getContainerSize() {
		return containersize;
	}
	public void setContainerSize(int containerSize) {
		this.containersize = containerSize;
	}
	public ContainerType getContainerType() {
		return containertype;
	}
	public void setContainerType(ContainerType containerType) {
		this.containertype = containerType;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
}
