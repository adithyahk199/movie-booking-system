package com.pwioi.movie.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pwioi.movie.config.DBConnectivity;
import com.pwioi.movie.model.Show;

public class ShowDAO {
	
	public void addShow(Show show) {
		
		String sql = "insert into shows (movie_id,show_date,show_time,screen_no,ticket_price) values(?,?,?,?,?)";
		
		try (Connection con = DBConnectivity.getDBConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setInt(1, show.getMovieId());
			pstmt.setString(2, show.getShowDate());
			pstmt.setString(3, show.getShowTime());
			pstmt.setInt(4, show.getScreenNo());
			pstmt.setDouble(5, show.getTicketPrice());
			
			pstmt.executeUpdate();
			
			System.out.println("Show added Successfully!!!!!!");
			
		} catch (IOException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public List getAllShows(){
		
		List<Show> shows = new ArrayList<>();
		
		String sql = "select * from shows";
		
		try (Connection con = DBConnectivity.getDBConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			while(rs.next()) {
				Show show = new Show();
				
				show.setShowId(rs.getInt("show_id"));
				show.setMovieId(rs.getInt(2));
				show.setShowDate(rs.getString(3));
				show.setShowTime(rs.getString(4));
				show.setScreenNo(rs.getInt(5));
				show.setTicketPrice(rs.getDouble(6));
				
				shows.add(show);
			}
		
			
		}
		
		catch (IOException | SQLException e) {
			
			e.printStackTrace();
		}
		return shows;
		
	}
	public Show getShowById(int showId)
	        throws IOException, SQLException {

	    String sql = "SELECT * FROM shows WHERE show_id = ?";

	    try (Connection con = DBConnectivity.getDBConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql)) {

	        pstmt.setInt(1, showId);

	        try (ResultSet rs = pstmt.executeQuery()) {

	            if (rs.next()) {

	                Show show = new Show();

	                show.setShowId(rs.getInt(1));
	                show.setMovieId(rs.getInt(2));
	                show.setShowDate(rs.getString(3));
	                show.setShowTime(rs.getString(4));
	                show.setScreenNo(rs.getInt(5));
	                show.setTicketPrice(rs.getDouble(6));

	                return show;
	            }
	        }
	    }

	    return null;
	}

}
