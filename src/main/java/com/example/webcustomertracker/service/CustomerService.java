package com.example.webcustomertracker.service;

import com.example.webcustomertracker.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAllCustomers();

    public void addCustomer(Customer customer);

    public void deleteCustomer(int customerId);

    Customer getCustomer(int customerId);

    void updateCustomer(Customer customer);
}
