package Models;

/**
 * @author : Ibrahim Sadigov
 * @mailto : isadigov4638@ada.edu.az
 * @created : 20 July, 2024
 **/
public class BookingDates {

    private String checkin;
    private String checkout;

    public BookingDates() {
    }

    public BookingDates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public BookingDates setCheckin(String checkin) {
        this.checkin = checkin;
        return this;
    }

    public String getCheckout() {
        return checkout;
    }

    public BookingDates setCheckout(String checkout) {
        this.checkout = checkout;
        return this;
    }
}
