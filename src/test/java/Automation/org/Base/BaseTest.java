package Automation.org.Base;

// Common class to all Test cases
import Automation.org.Asserts.AssertionsActions;
import Automation.org.Endpoints.APIConstants;
import Automation.org.Modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeTest;

public class BaseTest {
    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;
    public PayloadManager payloadManager;
    public AssertionsActions assertionsActions;


    @BeforeTest
    public void setup(){
        payloadManager=new PayloadManager();
        assertionsActions=new AssertionsActions();

//        requestSpecification= RestAssured.given();
//        requestSpecification.baseUri(APIConstants.BASE_URl);
//        requestSpecification.contentType(ContentType.JSON).log().all();

        // New RequestSpecBuilder Class
        requestSpecification= new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URl)
                .addHeader("Content-Type","application/json")
                .build().log().all();

    }

    public String getToken(){

        requestSpecification.basePath(APIConstants.AUTH_URL);
        response=RestAssured.given(requestSpecification)
                .contentType(ContentType.JSON)
                .body(payloadManager.createAuth()).when().post();

        validatableResponse=response.then().log().all();
        String token= payloadManager.getTokenResponse(response.asString());

        return token;
    }
}
