package com.pwioi.movie.service;

import java.io.IOException;
import java.sql.SQLException;

import com.pwioi.movie.dao.BookingDAO;
import com.pwioi.movie.dao.ShowDAO;
import com.pwioi.movie.model.Booking;
import com.pwioi.movie.model.Show;

public class BookingService {

    private BookingDAO bookingDAO;
    private ShowDAO showDAO;

    public BookingService() {

        bookingDAO = new BookingDAO();
        showDAO = new ShowDAO();
    }

    public void bookTicket(int customerId,
                           int showId,
                           int seats)
            throws IOException, SQLException {

        // Check seats
        if (seats <= 0) {

            System.out.println("Number of seats must be greater than 0.");
            return;
        }

        // Find the selected show
        Show show = showDAO.getShowById(showId);

        if (show == null) {

            System.out.println("Show not found!");
            return;
        }

        // Calculate total amount
        double totalAmount =
                show.getTicketPrice() * seats;

        // Create booking object
        Booking booking = new Booking();

        booking.setCustomerId(customerId);
        booking.setShowId(showId);
        booking.setSeats(seats);
        booking.setTotalAmount(totalAmount);

        // Save booking
        bookingDAO.createBooking(booking);

        System.out.println("Booking successful!");
        System.out.println("Number of seats: " + seats);
        System.out.println("Ticket price: ₹" + show.getTicketPrice());
        System.out.println("Total amount: ₹" + totalAmount);
    }
}