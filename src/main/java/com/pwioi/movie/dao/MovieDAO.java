package com.pwioi.movie.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pwioi.movie.config.DBConnectivity;
import com.pwioi.movie.model.Movie;

public class MovieDAO {

    // Add movie
    public void addMovie(Movie movie){

        String sql = "INSERT INTO movies "
                   + "(title, genre, language, duration, release_date) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnectivity.getDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, movie.getTitle());
            pstmt.setString(2, movie.getGenre());
            pstmt.setString(3, movie.getLanguage());
            pstmt.setInt(4, movie.getDuration());
            pstmt.setDate(5, java.sql.Date.valueOf(movie.getReleaseDate()));

            pstmt.executeUpdate();

            System.out.println("Movie added successfully!");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }


    // Get all movies
    public List<Movie> getAllMovies() {

        List<Movie> movies = new ArrayList<>();

        String sql = "SELECT * FROM movies";

        try (Connection con = DBConnectivity.getDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
        	
            while (rs.next()) {

                Movie movie = new Movie();

                movie.setMovieId(rs.getInt("movie_id"));
                movie.setTitle(rs.getString("title"));
                movie.setGenre(rs.getString("genre"));
                movie.setLanguage(rs.getString("language"));
                movie.setDuration(rs.getInt("duration"));
                movie.setReleaseDate(
                    rs.getDate("release_date").toLocalDate()
                );
                 
                movies.add(movie);
            }

        } catch (SQLException | IOException e) {
        	
            e.printStackTrace();
            
        }

        return movies;
    }
}