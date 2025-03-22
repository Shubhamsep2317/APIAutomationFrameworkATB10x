package Automation.org.Test.CRUD;

import Automation.org.Base.BaseTest;
import Automation.org.Endpoints.APIConstants;
import Automation.org.Modules.PayloadManager;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestCreateAuth extends BaseTest {


    @Owner("Shubham SDET")
    @Test(groups = "Regression", priority = 2,invocationCount = 5)
    @Description("TC-1---->>>> Create Auth Token")
    public void test_createAuth() {

        // Pre-requisites
        requestSpecification.basePath(APIConstants.AUTH_URL);

        // Making HTTP request
        Response response = RestAssured.given(requestSpecification).when()
                .body(payloadManager.createAuth()).post();

        // Validating Response
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Assertion Actions
        String token= payloadManager.getTokenResponse(response.asString());
        assertionsActions.verifyStringKeyNotNull(token);

    }
}
