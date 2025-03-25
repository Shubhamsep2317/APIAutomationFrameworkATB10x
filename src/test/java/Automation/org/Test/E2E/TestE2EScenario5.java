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

import static org.assertj.core.api.Assertions.assertThat;

public class TestE2EScenario5 extends BaseTest {

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
        System.out.println(iTestContext.getAttribute("bookingid"));
    }

    @Description("Delete Booking")
    @Owner("Shubham SDET")
    @Test(groups = "qa", priority = 2)
    public void deleteBooking(ITestContext iTestContext) {

        String token=getToken();
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        iTestContext.setAttribute("token",token);

        requestSpecification.basePath(APIConstants.CREATE_READ_UPDATE_DELETE + "/" + bookingid);
        response = RestAssured.given(requestSpecification)
                .cookie("token", token)
                .when().delete();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
    }

    @Description("Updating the deleted booking should be not allowed-405")
    @Owner("Shubham")
    @Test(groups = "qa",priority = 3)
    public void updateBookingID(ITestContext iTestContext){

        Integer bookingid=(Integer) iTestContext.getAttribute("bookingid");
        String token=(String) iTestContext.getAttribute("token");
        iTestContext.setAttribute("token",token);

        requestSpecification.basePath(APIConstants.CREATE_READ_UPDATE_DELETE+"/"+bookingid);
        response=RestAssured.given(requestSpecification)
                .cookie("token",token).when()
                .body(payloadManager.updatePayloadBookingAsString()).put();
        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(405);
    }



}
