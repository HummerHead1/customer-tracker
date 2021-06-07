package com.example.webcustomertracker.controller;


import com.example.webcustomertracker.DAO.CustomerDAO;
import com.example.webcustomertracker.entity.Customer;
import com.example.webcustomertracker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping( "/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "listCustomers";
    }

    @GetMapping("/addCustomerForm")
    public String addCustomerForm(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);

        return "addCustomer-form";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("customer") Customer customer){
        customerService.addCustomer(customer);
        System.out.println(customer.getFirstName());
        System.out.println(customer.getLastName());
        System.out.println(customer.getEmail());
        return "redirect:list";
    }
    
    @RequestMapping(value = "/deleteCustomer",method={RequestMethod.DELETE, RequestMethod.GET})
    public String deleteCustomer(@RequestParam(value = "customerId") int customerId){
        customerService.deleteCustomer(customerId);
        System.out.println(customerId);
        return "redirect:/customer/list";
    }

    @GetMapping(value = "/updateCustomerForm")
    public String updateCustomerForm(@RequestParam(value = "customerId") int customerId,Model model){
        System.out.println("updatecustomer METHOD!!!!!");
        Customer customer = customerService.getCustomer(customerId);
        model.addAttribute("customer",customer);

        return "customer-form";
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute("customer") Customer customer){
        customerService.updateCustomer(customer);
        return "redirect:/customer/list";
    }
}
