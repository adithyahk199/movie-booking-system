package com.pwioi.movie.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pwioi.movie.config.DBConnectivity;
import com.pwioi.movie.model.Booking;

public class BookingDAO {
	public void createBooking(Booking booking) {
		
		String sql = "insert into bookings (customer_id,show_id,seats,total_amount) values(?,?,?,?)";
		
		try (Connection con = DBConnectivity.getDBConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setInt(1, booking.getCustomerId());
			pstmt.setInt(2, booking.getShowId());
			pstmt.setInt(3, booking.getSeats());
			pstmt.setDouble(4, booking.getTotalAmount());
			
			pstmt.executeUpdate();
			
			System.out.println("Booking Created Successfully!!!");
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
