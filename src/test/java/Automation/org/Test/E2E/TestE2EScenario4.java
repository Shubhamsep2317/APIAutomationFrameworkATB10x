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

public class TestE2EScenario4 extends BaseTest {

    @Description("TC-1 Create Booking")
    @Owner("Shubham")
    @Test(groups = "qa",priority = 1)
    public void createBooking(ITestContext iTestContext){

        requestSpecification.basePath(APIConstants.CREATE_READ_UPDATE_DELETE);
        response = RestAssured.given(requestSpecification).when()
                .body(payloadManager.createPayloadBookingAsString()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        BookingResponse bookingResponse = payloadManager.getJavaObjectResponse(response.asString());
        iTestContext.setAttribute("bookingid",bookingResponse.getBookingid());
    }

    @Description("Update Booking")
    @Owner("Shubham")
    @Test(groups = "qa",priority = 2)
    public void updateBookingID(ITestContext iTestContext){

        Integer bookingid=(Integer) iTestContext.getAttribute("bookingid");
        String token=getToken();
        iTestContext.setAttribute("token",token);

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

    @Description("Delete Booking")
    @Owner("Shubham SDET")
    @Test(groups = "qa", priority = 3)
    public void deleteBooking(ITestContext iTestContext) {

        String token=(String) iTestContext.getAttribute("token");
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");

        requestSpecification.basePath(APIConstants.CREATE_READ_UPDATE_DELETE + "/" + bookingid);
        response = RestAssured.given(requestSpecification)
                .cookie("token", token)
                .when().delete();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
    }



}
