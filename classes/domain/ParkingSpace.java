public class ParkingSpace {
	private Address address;
	private boolean availability;
	private Credits price;
	private TimeRange timeRange;

	public ParkingSpace(Address address, boolean availability, Credits price, TimeRange timeRange) {
		this.address = address;
		this.availability = availability;
		this.price = price;
		this.timeRange = timeRange;
	}

	public ParkingSpace() {
		this.address = new Address();
		this.availability = false;
		this.price = new Credits();
		this.timeRange = new TimeRange();
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

	public void setPrice(Credits price) {
		this.price = price;
	}

	public TimeRange getTimeRange() {
		return timeRange;
	}

	public void setTimeRange(TimeRange timeRange) {
		this.timeRange = timeRange;
	}

	@Override
	public String toString() {
		return "ParkingSpace{" +
				"address=" + address +
				", availability=" + availability +
				", price=" + price +
				", timeRange=" + timeRange +
				'}';
	}
}