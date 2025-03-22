package Automation.org.Asserts;

import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.*;
import static org.testng.Assert.*;

public class AssertionsActions {

    public void verifyResponseBody(String actual, String expected, String description) {
        assertEquals(actual, expected, description);
    }

    public void verifyResponseBody(int actual, int expected, String description) {
        assertEquals(actual, expected, description);
    }

    public void verifyStatusCode(Response response, Integer expectedResponse) {
        assertEquals(response.getStatusCode(), expectedResponse);
    }
    //Assert J
    public void verifyStringKey(String keyExpect, String keyActual) {
        assertThat(keyExpect).isNotNull();
        assertThat(keyExpect).isNotBlank();
        assertThat(keyActual).isEqualTo(keyExpect);
    }

}
