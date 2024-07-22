package Services;

import Models.Booking;
import Models.ResponseBooking;
import Models.Token;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * @author : Ibrahim Sadigov
 * @mailto : isadigov4638@ada.edu.az
 * @created : 20 July, 2024
 **/
public class BookingService extends BaseService{

    public String generateToken(){
        Token token = new Token("admin", "password123");

        return given(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(token)
                .post(AUTH)
                .then()
                .statusCode(200)
                .extract().response().path("token");
    }

    public Response getBookings(){
        return given(spec)
               .when()
               .get(BOOKING)
               .then()
               .statusCode(200)
               .extract().response();
    }

    public Models.Response createBooking(Booking booking){

        //BookingDates bookingDates = new BookingDates("2018-01-01", "2019-01-01");

//        BookingDates bookingDates = new BookingDates(checkIn, checkOut);

//        Booking booking = new Booking("Ibrahim", "Sadigov", 111,
//                true, bookingDates, "Breakfast");

//        Booking booking = new Booking(firstName, lastName, totalPrice, depositPaid,
//                bookingDates, additionalNeeds);

        Models.Response responseModel = new Models.Response();

        Response response = given(spec)
                .contentType(ContentType.JSON)
                .body(booking)
                .when()
                .post(BOOKING)
                .then()
                .extract().response();

        responseModel.setStatus(response.getStatusCode());
//        JsonPath jsonPath = response.jsonPath();

//        assertThat("First name is incorrect", jsonPath.getString("booking.firstname"), equalTo("Ibrahim"));
//        assertThat("Last name is incorrect", jsonPath.getString("booking.lastname"), equalTo("Sadigov"));
//        assertThat("Total price is incorrect", jsonPath.getInt("booking.totalprice"), equalTo(111));
//        assertThat("Deposit paid status is incorrect", jsonPath.getBoolean("booking.depositpaid"), equalTo(true));
//        assertThat("Check-in date is incorrect", jsonPath.getString("booking.bookingdates.checkin"), equalTo("2018-01-01"));
//        assertThat("Check-out date is incorrect", jsonPath.getString("booking.bookingdates.checkout"), equalTo("2019-01-01"));
//        assertThat("Additional needs are incorrect", jsonPath.getString("booking.additionalneeds"), equalTo("Breakfast"));

//        assertThat("First name is incorrect", jsonPath.getString("booking.firstname"), equalTo(firstName));
//        assertThat("Last name is incorrect", jsonPath.getString("booking.lastname"), equalTo(lastName));
//        assertThat("Total price is incorrect", jsonPath.getInt("booking.totalprice"), equalTo(totalPrice));
//        assertThat("Deposit paid status is incorrect", jsonPath.getBoolean("booking.depositpaid"), equalTo(depositPaid));
//        assertThat("Check-in date is incorrect", jsonPath.getString("booking.bookingdates.checkin"), equalTo(checkIn));
//        assertThat("Check-out date is incorrect", jsonPath.getString("booking.bookingdates.checkout"), equalTo(checkOut));
//        assertThat("Additional needs are incorrect", jsonPath.getString("booking.additionalneeds"), equalTo(additionalNeeds));
//
//        System.out.println("CreateBookingService Assertions passed successfully!");
        if (response.getStatusCode() == 500){
            return responseModel;
        }
        return responseModel.setResponse(response.as(ResponseBooking.class));
    }

    public void deleteBooking(String token, int bookingId){
        given(spec)
                .contentType(ContentType.JSON)
                .header("Cookie", "Token= " + token)
                .when()
                .delete(BOOKING + "/" + bookingId)
                .then()
                .statusCode(201);
    }

}
