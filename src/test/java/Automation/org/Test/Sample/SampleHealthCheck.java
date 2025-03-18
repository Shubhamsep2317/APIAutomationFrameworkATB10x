package Automation.org.Test.Sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleHealthCheck {

    // Create Booking
    // Verify BookingID
    // Update BookingID
    // Delete Booking

    @Description("TC-1 Create Booking")
    @Owner("Shubham")
    @Test(groups = "qa",priority = 1)
    public void createBooking(){
        System.out.println("Booking created");
        Assert.assertTrue(true);
    }

    @Description("TC-1 Verify Booking ID")
    @Owner("Shubham")
    @Test(groups = "qa",priority = 2)
    public void verifyBookingID(){
        System.out.println("Booking is verified");
        Assert.assertTrue(true);
    }

    @Description("TC-1 Update Booking ID")
    @Owner("Shubham")
    @Test(groups = "qa",priority = 3)
    public void updateBookingID(){
        System.out.println("Booking ID is updated");
        Assert.assertTrue(true);
    }

    @Description("TC-1 Delete Booking")
    @Owner("Shubham")
    @Test(groups = "qa",priority = 4)
    public void deleteBooking(){
        System.out.println("Booking is deleted");
        Assert.assertTrue(true);
    }
}
