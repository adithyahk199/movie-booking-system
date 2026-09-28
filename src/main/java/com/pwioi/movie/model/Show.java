package com.pwioi.movie.model;

public class Show {
	private int showId;
	private int movieId;
	private String showDate;
	private String showTime;
	private int ScreenNo;
	private double ticketPrice;
	
	public Show() {
		
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	public String getShowDate() {
		return showDate;
	}

	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public int getScreenNo() {
		return ScreenNo;
	}

	public void setScreenNo(int screenNo) {
		ScreenNo = screenNo;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	
	}
	
}
