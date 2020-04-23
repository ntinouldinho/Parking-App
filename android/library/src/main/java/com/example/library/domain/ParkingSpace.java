package com.example.library.domain;

import com.example.library.util.Credits;
import com.example.library.util.TimeRange;

import java.util.Date;

public class ParkingSpace {
	private Address address;
	private boolean availability;
	private Credits price;
	private TimeRange timeRange;
	private Date timeOfExchange;
	private User parkedUser;

	private static final double max_amount = 16.0;
	private static final double min_amount = 0.0;


	public ParkingSpace(Address address, boolean availability, Credits price, TimeRange timeRange, Date timeOfExchange, User parkedUser) {
		this.address = address;
		this.availability = availability;
		this.price = price;
		this.timeRange = timeRange;
		this.timeOfExchange=timeOfExchange;
		this.parkedUser=parkedUser;
	}



	public ParkingSpace() {
		this.address = new Address();
		this.availability = false;
		this.price = new Credits();
		this.timeRange = new TimeRange();
		this.timeOfExchange = new Date();
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Credits getPrice() {
		return price;
	}

	public boolean setPrice(Credits price) {
		if(price.getPoints()>= min_amount && price.getPoints()<=max_amount) {
			this.price = price;
			return true;
		}

		return false;
	}

	public TimeRange getTimeRange() {
		return timeRange;
	}

	public void setTimeRange(TimeRange timeRange) {
		this.timeRange = timeRange;
	}

	public Date getTimeOfExchange() {
		return timeOfExchange;
	}

	public void setTimeOfExchange(Date timeOfExchange) {
		this.timeOfExchange = timeOfExchange;
	}

	public void makeParkingUnavailable(){
		availability=false;
		setTimeOfExchange(new Date(System.currentTimeMillis()));
	}

	public void makeParkingAvailable(){
		availability=true;
		setTimeOfExchange(new Date());
	}

	public User getParkedUser() {
		return parkedUser;
	}

	public void setParkedUser(User parkedUser) {
		this.parkedUser = parkedUser;
	}

	@Override
	public String toString() {
		return "ParkingSpace{" +
				"address=" + address +
				", availability=" + availability +
				", price=" + price +
				", timeRange=" + timeRange +
				", timeOfExchange=" + timeOfExchange +
				", parkedUser=" + parkedUser +
				'}';
	}
}