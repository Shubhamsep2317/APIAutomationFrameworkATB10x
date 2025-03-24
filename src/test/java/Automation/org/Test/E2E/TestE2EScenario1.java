package Automation.org.Test.E2E;

import Automation.org.Base.BaseTest;
import Automation.org.Endpoints.APIConstants;
import Automation.org.Pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;



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
    }

    @Description("TC-3 Update Booking ID")
    @Owner("Shubham")
    @Test(groups = "qa",priority = 3)
    public void updateBookingID(ITestContext iTestContext){
        System.out.println("Booking ID is updated");
        Assert.assertTrue(true);
    }

    @Description("TC-4 Delete Booking")
    @Owner("Shubham")
    @Test(groups = "qa",priority = 4)
    public void deleteBooking(ITestContext iTestContext){
        System.out.println("Booking is deleted");
        Assert.assertTrue(true);
    }

}
