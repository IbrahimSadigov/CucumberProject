package Models;

/**
 * @author : Ibrahim Sadigov
 * @mailto : isadigov4638@ada.edu.az
 * @created : 20 July, 2024
 **/
public class ResponseBooking {

    private  int bookingid;
    private Booking booking;

    public ResponseBooking() {
    }

    public ResponseBooking(int bookingid, Booking booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public int getBookingid() {
        return bookingid;
    }

    public ResponseBooking setBookingid(int bookingid) {
        this.bookingid = bookingid;
        return this;
    }

    public Booking getBooking() {
        return booking;
    }

    public ResponseBooking setBooking(Booking booking) {
        this.booking = booking;
        return this;
    }
}
