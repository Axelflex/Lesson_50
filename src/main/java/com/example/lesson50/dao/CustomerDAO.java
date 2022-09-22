package com.example.lesson50.dao;

import com.example.lesson50.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerDAO {
    private final JdbcTemplate jdbcTemplate;
    public List<Customer> getAllCustomers(){
        String query = "select * from customers";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Customer.class));
    }

}
