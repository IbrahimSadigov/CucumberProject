package Models;

/**
 * @author : Ibrahim Sadigov
 * @mailto : isadigov4638@ada.edu.az
 * @created : 20 July, 2024
 **/
public class Booking {

    private String firstname;
    private String lastname;
    private int totalprice;
    private Boolean depositpaid;
    private BookingDates bookingdates;
    private String aditionalneeds;

    public Booking() {
    }

    public Booking(String firstname, String lastname, int totalprice, Boolean depositpaid, BookingDates bookingdates, String aditionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.aditionalneeds = aditionalneeds;
    }

    public String getFirstname() {
        return firstname;
    }

    public Booking setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Booking setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public Booking setTotalprice(int totalprice) {
        this.totalprice = totalprice;
        return this;
    }

    public Boolean isDepositpaid() {
        return depositpaid;
    }

    public Booking setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
        return this;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public Booking setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
        return this;
    }

    public String getAditionalneeds() {
        return aditionalneeds;
    }

    public Booking setAditionalneeds(String aditionalneeds) {
        this.aditionalneeds = aditionalneeds;
        return this;
    }
}
