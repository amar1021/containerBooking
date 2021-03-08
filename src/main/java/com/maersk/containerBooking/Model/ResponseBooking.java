package com.maersk.containerBooking.Model;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class ResponseBooking {

	private int containersize;
	
	@Enumerated(EnumType.STRING)
	private ContainerType containertype = ContainerType.DRY;
	
	private String origin;
	private String destination;
	private int quantity;
	
	public ResponseBooking(int containerSize, ContainerType containerType, String origin, String destination,
			int quantity) {
		super();
		this.containersize = containerSize;
		this.containertype = containerType;
		this.origin = origin;
		this.destination = destination;
		this.quantity = quantity;
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
}
