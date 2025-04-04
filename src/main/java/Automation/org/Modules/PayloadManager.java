package Automation.org.Modules;

import Automation.org.Pojos.*;
import com.google.gson.Gson;

public class PayloadManager {

    // Convert the Java objects to JSON or vice versa
    // Serialization and De-serialization

    // Serialization
    public String createPayloadBookingAsString() {

        Booking booking = new Booking();
        booking.setFirstname("Shubham");
        booking.setLastname("Sharma");
        booking.setTotalprice(1000);
        booking.setDepositpaid(false);
        booking.setAdditionalneeds("Breakfast");

        Bookingdates bd = new Bookingdates();
        bd.setCheckin("12-04-2025");
        bd.setCheckout("13-04-2025");

        booking.setBookingdates(bd);

        // Java Object to JSON
        Gson gson = new Gson();
        String stringPayloadBooking = gson.toJson(booking);

        return stringPayloadBooking;
    }

    public String updatePayloadBookingAsString() {

        Booking booking = new Booking();
        booking.setFirstname("abc");
        booking.setLastname("xyz");
        booking.setTotalprice(2000);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Dinner");

        Bookingdates bd = new Bookingdates();
        bd.setCheckin("10-10-2025");
        bd.setCheckout("10-10-2025");

        booking.setBookingdates(bd);

        // Java Object to JSON
        Gson gson = new Gson();
        String stringUpdatedPayloadBooking = gson.toJson(booking);

        return stringUpdatedPayloadBooking;
    }

    // De-serialization --->> JSON to Java Object
    public BookingResponse getJavaObjectResponse(String response) {

        Gson gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(response, BookingResponse.class);

        return bookingResponse;
    }

    public Booking getJavaObjectBooking(String response) {

        Gson gson = new Gson();
        Booking booking = gson.fromJson(response, Booking.class);

        return booking;
    }


    public String createAuth() {

        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        // Java Object to JSON
        Gson gson = new Gson();
        String stringPayloadAuth = gson.toJson(auth);
        return stringPayloadAuth;
    }

    // De-serialization --->> JSON to Java Object for Auth
    public String getTokenResponse(String response) {
        Gson gson = new Gson();
        TokenResponse tokenResponse = gson.fromJson(response, TokenResponse.class);

        return tokenResponse.getToken().toString();
    }

}
