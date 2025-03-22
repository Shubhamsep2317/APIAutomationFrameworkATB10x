package Automation.org.Test.CRUD;

import Automation.org.Base.BaseTest;
import Automation.org.Endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestHealthCheck extends BaseTest {
    @Owner("Shubham SDET")
    @Test(groups = "Regression", priority = 2)
    @Description("TC-1---->>>> Create Auth Token")
    public void test_createAuth() {

        // Pre-requisites
        requestSpecification.basePath(APIConstants.PING_URL);

        // Making HTTP request
        Response response = RestAssured.given(requestSpecification).when()
                .get();

        // Validating Response
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);

    }

}
