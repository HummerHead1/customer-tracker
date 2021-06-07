package com.example.webcustomertracker.DAO;

import com.example.webcustomertracker.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(Customer.class)
            .configure(new File("src/hibernate.cfg.xml"))
            .buildSessionFactory();
    Session session = sessionFactory.openSession();

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = session.createQuery("from Customer ORDER BY firstName").getResultList();
        return customers;
    }

    @Override
    public void addCustomerDAO(Customer customer) {
        session.beginTransaction();
        session.clear();
        session.saveOrUpdate(customer);
        session.getTransaction().commit();
        System.out.println("Customer is: " + customer);

    }

    @Override
    public void deleteCustomer(int customerId) {
        session.beginTransaction();
        Customer customer = session.get(Customer.class, customerId);
        session.delete(customer);
        session.getTransaction().commit();
        System.out.println("Customer: " + customer + " was deleted");
    }

    @Override
    public Customer getCustomer(int customerId) {
        session.beginTransaction();
        Customer customer = session.get(Customer.class,customerId);
        session.getTransaction().commit();
        return customer;
    }

//    @Override
//    public void updateCustomer(Customer customer) {
//        session.beginTransaction();
//        Customer dbcustomer= session.get(Customer.class,customer.getId());
//        dbcustomer.setFirstName(customer.getFirstName());
//        dbcustomer.setLastName(customer.getLastName());
//        dbcustomer.setEmail(customer.getEmail());
//        session.getTransaction().commit();
//    }


}
