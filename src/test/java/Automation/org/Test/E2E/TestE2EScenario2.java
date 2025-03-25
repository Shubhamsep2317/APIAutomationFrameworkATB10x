package Automation.org.Test.E2E;

import Automation.org.Base.BaseTest;
import Automation.org.Endpoints.APIConstants;
import Automation.org.Pojos.BookingResponse;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import io.qameta.allure.Description;


public class TestE2EScenario2 extends BaseTest {

    @Description("Verify Create Booking")
    @Owner("Shubham SDET")
    @Test(groups = "qa", priority = 1)
    public void createBooking(ITestContext iTestContext) {

        requestSpecification.basePath(APIConstants.CREATE_READ_UPDATE_DELETE);
        response = RestAssured.given(requestSpecification)
                .body(payloadManager.createPayloadBookingAsString())
                .when().post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        BookingResponse bookingResponse = payloadManager.getJavaObjectResponse(response.asString());
        iTestContext.setAttribute("bookingid", bookingResponse.getBookingid());
    }

    @Description("TC-4 Delete Booking")
    @Owner("Shubham SDET")
    @Test(groups = "qa", priority = 2)
    public void deleteBooking(ITestContext iTestContext) {

        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String token = getToken();

        requestSpecification.basePath(APIConstants.CREATE_READ_UPDATE_DELETE + "/" + bookingid);
        response = RestAssured.given(requestSpecification)
                .cookie("token", token)
                .when().delete();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
    }

    @Description("TC-2 Verify if booking is deleted permanently")
    @Owner("Shubham SDET")
    @Test(groups = "qa", priority = 3)
    public void verifyBookingID(ITestContext iTestContext) {

        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");

        requestSpecification.basePath(APIConstants.CREATE_READ_UPDATE_DELETE + "/" + bookingid);
        response = RestAssured.given(requestSpecification).get();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(404);

    }




}
