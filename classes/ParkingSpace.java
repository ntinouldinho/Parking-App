public class ParkingSpace {
	private Address address;
	private boolean availability;

	public ParkingSpace(Address address, boolean availability) {
		this.address = address;
		this.availability = availability;
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

	@java.lang.Override
	public java.lang.String toString() {
		return "ParkingSpace{" +
				"address=" + address +
				", availability=" + availability +
				'}';
	}
}