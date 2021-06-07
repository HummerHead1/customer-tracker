package com.example.webcustomertracker.DAO;

import com.example.webcustomertracker.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void addCustomerDAO(Customer customer);

    void deleteCustomer(int customerId);

    Customer getCustomer(int customerId);

//    void updateCustomer(Customer customer);
}
