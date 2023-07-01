package com.customer.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.college.service.CustomerService;
import com.customer.model.Customer;
import com.customer.util.DbUtil;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	List<Customer> customerlist = new ArrayList<>();
	Connection connection;
	
	public CustomerServiceImpl() throws ClassNotFoundException {
		connection = DbUtil.getConnection();
	}

	@Override
	public List<Customer> getCustomerList(){
		Customer cust;
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM T_CUSTOMER");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				cust = new Customer();
				cust.setId(rs.getInt(1));
				cust.setFirstname(rs.getString(2));
				cust.setLastname(rs.getString(3));
				cust.setRegion(rs.getString(4));
				cust.setEmail(rs.getString(5));
				cust.setPhone(rs.getInt(6));
				customerlist.add(cust);
				System.out.println("Fname "+cust.getFirstname());
				System.out.println("Lname "+cust.getLastname());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customerlist;
	}
}
