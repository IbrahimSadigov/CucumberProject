package StepDefinitions;

import Models.Booking;
import Models.BookingDates;
import Models.Response;
import Models.ResponseBooking;
import Services.BookingService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author : Ibrahim Sadigov
 * @mailto : isadigov4638@ada.edu.az
 * @created : 21 July, 2024
 **/
public class BookingSteps {

    BookingService bookingService = new BookingService();
    Response response;
    ResponseBooking responseBooking;
    Booking booking;

    @Given("Create booking with valid data")
    public void createBookingWithValidData() {
        booking = new Booking("Ibrahim", "Sadigov", 111,
                true, new BookingDates("2018-01-01", "2019-01-01"), "Breakfast");
    }

    @Given("I have booking details with missing required fields")
    public void createBookingWithMissingData() {
        booking = new Booking("Ibrahim", "Sadigov", 111,
                null, new BookingDates("2018-01-01", "2019-01-01"),
                "Breakfast");
    }

    @Given("I have booking details with invalid data types")
    public void createBookingWithInvalidDataType(){
        booking = new Booking("Ibrahim", "Sadigov", 111,
                true, new BookingDates("2018-01-01", "2019-01-01"),
                "Breakfast");
    }

    @When("I send a POST request to the Create Booking API")
    public void sendPostRequestToCreateBookingApi() {
        response = bookingService.createBooking(booking);
    }

    @Then("I should receive a {int} status code")
    public void checkStatusCode(int statusCode){
        assertThat("Status code is not " + statusCode, response.getStatus(), equalTo(statusCode));
    }

    @Then("The response should contain the booking details")
    public void checkBookingDetails() {
        Object o = response.getResponse();
        if (o instanceof ResponseBooking){
            responseBooking = (ResponseBooking) o;
            Booking bookingDetails = responseBooking.getBooking();
            assertThat("First name is incorrect", bookingDetails.getFirstname(), equalTo("Ibrahim"));
            assertThat("Last name is incorrect", bookingDetails.getLastname(), equalTo("Sadigov"));
            assertThat("Total price is incorrect", bookingDetails.getTotalprice(), equalTo(111));
            assertThat("Deposit paid status is incorrect", bookingDetails.isDepositpaid(), equalTo(true));
            assertThat("Check-in date is incorrect", bookingDetails.getBookingdates().getCheckin(), equalTo("2018-01-01"));
            assertThat("Check-out date is incorrect", bookingDetails.getBookingdates().getCheckout(), equalTo("2019-01-01"));
//            assertThat("Additional needs are incorrect", bookingDetails.getAditionalneeds(), equalTo("Breakfast"));
        }
    }

    @Then("The response body should contain an error message indicating the missing required fields")
    public void checkMissingFieldsErrorMessage() {
        Object o = response.getResponse();
        if (o instanceof ResponseBooking){
            responseBooking = (ResponseBooking) o;
            assertThat("Error message is not 'Missing required fields'", response.getMessage(), containsString("Missing required fields"));
        }
    }

    @Then("The response body should contain an error message indicating the invalid data types")
    public void checkInvalidDataTypeErrorMessage() {
        Object o = response.getResponse();
        if (o instanceof ResponseBooking){
            responseBooking = (ResponseBooking) o;
            assertThat("Error message is not 'Invalid data types'", response.getMessage(), containsString("Invalid data types"));
        }
    }

}
