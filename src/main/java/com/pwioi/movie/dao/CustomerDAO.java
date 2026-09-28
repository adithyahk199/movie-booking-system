package com.pwioi.movie.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pwioi.movie.config.DBConnectivity;
import com.pwioi.movie.model.Customer;

public class CustomerDAO {

	public void addCustomer(Customer customer) {
		
		String sql =  "insert into customers (name,email,phone) values(?,?,?)";
		
		try (Connection con = DBConnectivity.getDBConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getEmail());
			pstmt.setString(3, customer.getPhone());
			
			pstmt.executeUpdate();
			
			System.out.println("customers added successsfully!!!");
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Customer> getAllCustomers(){
		
		List<Customer> Customers = new ArrayList<>();
		
		String sql = "SELECT * FROM customers";
		
		try (Connection con = DBConnectivity.getDBConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			
			while(rs.next()) {
				Customer customer = new Customer();
				
				customer.setCustomerId(rs.getInt(1));
				customer.setName(rs.getString(2));
				customer.setEmail(rs.getString(3));
				customer.setPhone(rs.getString(4));
				
				
				Customers.add(customer);
			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Customers;
	}
	
	public Customer getCustomerById(int customer_id)
	        throws IOException, SQLException {

	    String sql = "SELECT * FROM customers WHERE customer_id=?";

	    try (Connection con = DBConnectivity.getDBConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql)) {

	        pstmt.setInt(1, customer_id);

	        try (ResultSet rs = pstmt.executeQuery()) {

	            if (rs.next()) {

	                Customer customer = new Customer();

	                customer.setCustomerId(rs.getInt(1));
	                customer.setName(rs.getString(2));
	                customer.setEmail(rs.getString(3));
	                customer.setPhone(rs.getString(4));

	                return customer;
	            }
	        }

	    } catch (IOException | SQLException e) {
	        e.printStackTrace();
	    }

	    return null;
	}
}
