package Automation.org.Modules;

import Automation.org.Pojos.Booking;
import Automation.org.Pojos.BookingResponse;
import Automation.org.Pojos.Bookingdates;
import com.google.gson.Gson;
import io.qameta.allure.testng.TestInstanceParameter;

public class PayloadManager {

    // Convert the Java objects to JSON or vice versa
    // Serialization and De-serialization

    Gson gson;
    String stringPayloadBooking;
    BookingResponse bookingResponse;

    // Serialization
    public String createPayloadBookingAsString(){

        Booking booking =new Booking();
        booking.setFirstname("Shubham");
        booking.setLastname("Sharma");
        booking.setTotalprice(1000);
        booking.setDepositpaid(false);
        booking.setAdditionalneeds("Breakfast");

        Bookingdates bd=new Bookingdates();
        bd.setCheckin("12-04-2025");
        bd.setCheckout("13-04-2025");

        booking.setBookingdates(bd);

        // Java Object to JSON
        gson=new Gson();
        stringPayloadBooking = gson.toJson(booking);

    return stringPayloadBooking;
    }

    // De-serialization --->> JSON to Java Object
    public BookingResponse getJavaObjectResponse(String response){

        gson=new Gson();
        bookingResponse=gson.fromJson(response, BookingResponse.class);
        return  bookingResponse;
    }
}
