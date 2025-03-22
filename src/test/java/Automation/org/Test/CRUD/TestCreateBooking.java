package Automation.org.Test.CRUD;

import Automation.org.Base.BaseTest;
import Automation.org.Endpoints.APIConstants;
import Automation.org.Modules.PayloadManager;
import Automation.org.Pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateBooking extends BaseTest {

    @Owner("Shubham SDET")
    @Test(groups = "Reg", priority = 1)
    @Description("TC-1---->>>> Create Booking")
    public void test_createBooking() {

        // Pre-requisites
        requestSpecification.basePath(APIConstants.CREATE_READ_UPDATE_DELETE);

        // Making HTTP request
        response = RestAssured.given(requestSpecification).when()
                .body(PayloadManager.createPayloadBookingAsString()).post();

        // Validating Response
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Assertion Actions
        BookingResponse bookingResponse = payloadManager.getJavaObjectResponse(response.asString());
        assertionsActions.verifyStringKey(bookingResponse.getBooking().getFirstname(), "Shubham");
        assertionsActions.verifyStringKey(bookingResponse.getBooking().getLastname(), "Sharma");
        assertionsActions.verifyResponseBody(bookingResponse.getBooking().getTotalprice(), 1000, "Test to check Total price is correct");
    }


}
