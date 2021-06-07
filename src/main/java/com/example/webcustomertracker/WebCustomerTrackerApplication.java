package com.example.webcustomertracker;

import com.example.webcustomertracker.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class WebCustomerTrackerApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(WebCustomerTrackerApplication.class, args);
//        Map<String, String> settings = new HashMap<>();
//        settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
//        settings.put("dialect", "org.hibernate.dialect.MySQL8Dialect");
//        settings.put("hibernate.connection.url",
//                "jdbc:mysql://localhost:3306/instructions_shema");
//        settings.put("hibernate.connection.username", "root");
//        settings.put("hibernate.connection.password", "Eldar2001");
//        settings.put("hibernate.current_session_context_class", "thread");
//        settings.put("hibernate.show_sql", "true");
//        settings.put("hibernate.format_sql", "true");

//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .applySettings(settings).build();
//
//        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
//         metadataSources.addAnnotatedClass(Customer.class);
//        Metadata metadata = metadataSources.buildMetadata();
//
//        // here we build the SessionFactory (Hibernate 5.4)
//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        // setup connection variables
        String user = "root";
        String pass = "Eldar2001";

        String jdbcUrl = "jdbc:mysql://localhost:3306/instructions_shema?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";


        System.out.println("Connecting to database: " + jdbcUrl);


        Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

        System.out.println("SUCCESS!!!");

        myConn.close();

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Customer.class)
                .configure(new File("src/hibernate.cfg.xml"))
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }

}
