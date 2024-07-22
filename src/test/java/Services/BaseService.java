package Services;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.util.Arrays;

/**
 * @author : Ibrahim Sadigov
 * @mailto : isadigov4638@ada.edu.az
 * @created : 20 July, 2024
 **/
public class BaseService {

    public static final String BASE_URI = "https://restful-booker.herokuapp.com";
    public static final String BOOKING = "/booking";
    public static final String AUTH = "/auth";

    RequestSpecification spec;

    public BaseService() {
        RestAssured.baseURI = BASE_URI;

        spec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter()))
                .build();

    }


}
