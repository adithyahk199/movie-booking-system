package com.pwioi.movie;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.pwioi.movie.dao.CustomerDAO;
import com.pwioi.movie.dao.MovieDAO;
import com.pwioi.movie.dao.ShowDAO;
import com.pwioi.movie.model.Customer;
import com.pwioi.movie.model.Movie;
import com.pwioi.movie.model.Show;
import com.pwioi.movie.service.BookingService;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MovieDAO movieDAO = new MovieDAO();
        ShowDAO showDAO = new ShowDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        BookingService bookingService = new BookingService();

        while (true) {

            System.out.println("\n======================================");
            System.out.println("     MOVIE TICKET BOOKING SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Movie");
            System.out.println("2. View Movies");
            System.out.println("3. Add Show");
            System.out.println("4. View Shows");
            System.out.println("5. Add Customer");
            System.out.println("6. View Customers");
            System.out.println("7. Book Ticket");
            System.out.println("8. Exit");
            System.out.println("======================================");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {

                switch (choice) {

                // ==========================================
                // 1. ADD MOVIE
                // ==========================================
                case 1:

                    System.out.println("\n========== ADD MOVIE ==========");

                    Movie movie = new Movie();

                    System.out.print("Enter movie title: ");
                    movie.setTitle(sc.nextLine());

                    System.out.print("Enter genre: ");
                    movie.setGenre(sc.nextLine());

                    System.out.print("Enter language: ");
                    movie.setLanguage(sc.nextLine());

                    System.out.print("Enter duration in minutes: ");
                    movie.setDuration(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter release date (YYYY-MM-DD): ");
                    String releaseDate = sc.nextLine();

                    movie.setReleaseDate(
                            LocalDate.parse(releaseDate)
                    );

                    movieDAO.addMovie(movie);

                    break;


                // ==========================================
                // 2. VIEW MOVIES
                // ==========================================
                case 2:

                    System.out.println("\n========== ALL MOVIES ==========");

                    List<Movie> movies = movieDAO.getAllMovies();

                    if (movies.isEmpty()) {
                        System.out.println("No movies found.");
                    } else {

                        for (Movie m : movies) {

                            System.out.println("----------------------------------");
                            System.out.println("Movie ID     : " + m.getMovieId());
                            System.out.println("Title        : " + m.getTitle());
                            System.out.println("Genre        : " + m.getGenre());
                            System.out.println("Language     : " + m.getLanguage());
                            System.out.println("Duration     : " + m.getDuration() + " minutes");
                            System.out.println("Release Date : " + m.getReleaseDate());
                        }

                        System.out.println("----------------------------------");
                    }

                    break;


                // ==========================================
                // 3. ADD SHOW
                // ==========================================
                case 3:

                    System.out.println("\n========== ADD SHOW ==========");

                    Show show = new Show();

                    System.out.print("Enter Movie ID: ");
                    show.setMovieId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter show date (YYYY-MM-DD): ");
                    show.setShowDate(sc.nextLine());

                    System.out.print("Enter show time (HH:MM:SS): ");
                    show.setShowTime(sc.nextLine());

                    System.out.print("Enter screen number: ");
                    show.setScreenNo(sc.nextInt());

                    System.out.print("Enter ticket price: ");
                    show.setTicketPrice(sc.nextDouble());
                    sc.nextLine();

                    showDAO.addShow(show);

                    break;


                // ==========================================
                // 4. VIEW SHOWS
                // ==========================================
                case 4:

                    System.out.println("\n========== ALL SHOWS ==========");

                    List<Show> shows = showDAO.getAllShows();

                    if (shows.isEmpty()) {
                        System.out.println("No shows found.");
                    } else {

                        for (Show s : shows) {

                            System.out.println("----------------------------------");
                            System.out.println("Show ID      : " + s.getShowId());
                            System.out.println("Movie ID     : " + s.getMovieId());
                            System.out.println("Show Date    : " + s.getShowDate());
                            System.out.println("Show Time    : " + s.getShowTime());
                            System.out.println("Screen No    : " + s.getScreenNo());
                            System.out.println("Ticket Price : ₹" + s.getTicketPrice());
                        }

                        System.out.println("----------------------------------");
                    }

                    break;


                // ==========================================
                // 5. ADD CUSTOMER
                // ==========================================
                case 5:

                    System.out.println("\n========== ADD CUSTOMER ==========");

                    Customer customer = new Customer();

                    System.out.print("Enter customer name: ");
                    customer.setName(sc.nextLine());

                    System.out.print("Enter email: ");
                    customer.setEmail(sc.nextLine());

                    System.out.print("Enter phone: ");
                    customer.setPhone(sc.nextLine());

                    customerDAO.addCustomer(customer);

                    break;


                // ==========================================
                // 6. VIEW CUSTOMERS
                // ==========================================
                case 6:

                    System.out.println("\n========== ALL CUSTOMERS ==========");

                    List<Customer> customers =
                            customerDAO.getAllCustomers();

                    if (customers.isEmpty()) {
                        System.out.println("No customers found.");
                    } else {

                        for (Customer c : customers) {

                            System.out.println("----------------------------------");
                            System.out.println("Customer ID : " + c.getCustomerId());
                            System.out.println("Name        : " + c.getName());
                            System.out.println("Email       : " + c.getEmail());
                            System.out.println("Phone       : " + c.getPhone());
                        }

                        System.out.println("----------------------------------");
                    }

                    break;


                // ==========================================
                // 7. BOOK TICKET
                // ==========================================
                case 7:

                    System.out.println("\n========== BOOK TICKET ==========");

                    System.out.print("Enter Customer ID: ");
                    int customerId = sc.nextInt();

                    System.out.print("Enter Show ID: ");
                    int showId = sc.nextInt();

                    System.out.print("Enter Number of Seats: ");
                    int seats = sc.nextInt();
                    sc.nextLine();

                    bookingService.bookTicket(
                            customerId,
                            showId,
                            seats
                    );

                    break;


                // ==========================================
                // 8. EXIT
                // ==========================================
                case 8:

                    System.out.println("\nThank you for using Movie Ticket Booking System!");

                    sc.close();

                    return;


                default:

                    System.out.println("Invalid choice! Please try again.");
                }

            } catch (Exception e) {

                System.out.println("\nSomething went wrong!");
                e.printStackTrace();
            }
        }
    }
}