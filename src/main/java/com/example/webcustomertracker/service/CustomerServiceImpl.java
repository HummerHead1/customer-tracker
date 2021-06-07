package com.example.webcustomertracker.service;

import com.example.webcustomertracker.DAO.CustomerDAO;
import com.example.webcustomertracker.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getAllCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void addCustomer(Customer customer){
        customerDAO.addCustomerDAO(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(int customerId) {
        customerDAO.deleteCustomer(customerId);
    }

    @Override
    @Transactional
    public Customer getCustomer(int customerId) {
        return customerDAO.getCustomer(customerId);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDAO.addCustomerDAO(customer);
    }


}
