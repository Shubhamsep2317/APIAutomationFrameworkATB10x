package Automation.org.Test.E2E;

import Automation.org.Base.BaseTest;
import Automation.org.Endpoints.APIConstants;
import jdk.jfr.Description;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TestE2EScenario2 extends BaseTest {

    @Description("Verify Create Booking")
    @Test(priority = 1)
    public void createBooking(ITestContext iTestContext){

        requestSpecification.basePath(APIConstants.CREATE_READ_UPDATE_DELETE);



    }

}
