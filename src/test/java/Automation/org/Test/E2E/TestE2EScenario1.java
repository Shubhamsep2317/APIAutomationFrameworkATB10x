package Automation.org.Test.E2E;

import Automation.org.Base.BaseTest;
import Automation.org.Endpoints.APIConstants;
import Automation.org.Pojos.Booking;
import Automation.org.Pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;



public class TestE2EScenario1 extends BaseTest {
    // Create a Booking--->> Booking ID
    // Create Token
    // Get the BookingID
    // Update the Booking
    // Delete the Booking

    @Description("TC-1 Create Booking")
    @Owner("Shubham")
    @Test(groups = "qa",priority = 1)
    public void createBooking(ITestContext iTestContext){
        // Pre-requisites
        requestSpecification.basePath(APIConstants.CREATE_READ_UPDATE_DELETE);

        // Making HTTP request
        response = RestAssured.given(requestSpecification).when()
                .body(payloadManager.createPayloadBookingAsString()).post();

        // Validating Response
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Assertion Actions
        BookingResponse bookingResponse = payloadManager.getJavaObjectResponse(response.asString());
        iTestContext.setAttribute("bookingid",bookingResponse.getBookingid());
    }

    @Description("TC-2 Verify Booking ID")
    @Owner("Shubham")
    @Test(groups = "qa",priority = 2)
    public void verifyBookingID(ITestContext iTestContext){

       Integer bookingid=(Integer) iTestContext.getAttribute("bookingid");

       requestSpecification.basePath(APIConstants.CREATE_READ_UPDATE_DELETE+"/"+bookingid);
       response=RestAssured.given(requestSpecification).get();
       validatableResponse=response.then().log().all();
       validatableResponse.statusCode(200);

        Booking booking= payloadManager.getJavaObjectBooking(response.asString());
        assertThat(booking.getFirstname()).isNotBlank().isNotNull();
        assertThat(booking.getFirstname()).isEqualTo("Shubham");
        assertThat(booking.getLastname()).isEqualTo("Sharma");
    }

    @Description("TC-3 Update Booking ID")
    @Owner("Shubham")
    @Test(groups = "qa",priority = 3)
    public void updateBookingID(ITestContext iTestContext){
        Integer bookingid=(Integer) iTestContext.getAttribute("bookingid");

        iTestContext.setAttribute("token",getToken());
        String token=getToken();
        System.out.println(bookingid);
        requestSpecification.basePath(APIConstants.CREATE_READ_UPDATE_DELETE+"/"+bookingid);
        response=RestAssured.given(requestSpecification)
                .cookie("token",token).when()
                .body(payloadManager.updatePayloadBookingAsString()).put();
        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);

        Booking booking =payloadManager.getJavaObjectBooking(response.asString());

        assertThat(booking.getTotalprice()).isPositive().isEqualTo(2000);
        assertThat(booking.getFirstname()).isNotBlank().isEqualToIgnoringCase("abc");
        assertThat(booking.getLastname()).isNotBlank().isEqualToIgnoringCase("xyz");

    }

    @Description("TC-4 Delete Booking")
    @Owner("Shubham")
    @Test(groups = "qa",priority = 4)
    public void deleteBooking(ITestContext iTestContext){
        Integer bookingid= (Integer) iTestContext.getAttribute("bookingid");
        String token= (String) iTestContext.getAttribute("token");

        requestSpecification.basePath(APIConstants.CREATE_READ_UPDATE_DELETE+"/"+bookingid);
        response=RestAssured.given(requestSpecification)
                .cookie("token",token)
                .when().delete();
        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(201);
    }

}
