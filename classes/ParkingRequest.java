import java.util.Date;


public class ParkingRequest {
    private Date date;
    private Pin pin;
    private ZipCode zipCode;

    public ParkingRequest(Date date, Pin pin, ZipCode zipCode) {
        this.date = date;
        this.pin = pin;
        this.zipCode = zipCode;
    }

    public ParkingRequest() {
        this.date = new Date();
        this.pin = new Pin();
        this.zipCode = new ZipCode();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Pin getPin() {
        return pin;
    }

    public void setPin(Pin pin) {
        this.pin = pin;
    }

    public ZipCode getZipCode() {
        return zipCode;
    }

    public void setZipCode(ZipCode zipCode) {
        this.zipCode = zipCode;
    }
}
