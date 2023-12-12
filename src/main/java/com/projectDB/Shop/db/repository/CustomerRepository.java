package com.projectDB.Shop.db.repository;

import com.projectDB.Shop.db.mapper.CustomerRowMapper;
import com.projectDB.Shop.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

@Component
public class CustomerRepository {


    private final JdbcTemplate jdbcTemplate;
    private final CustomerRowMapper customerRowMapper = new CustomerRowMapper();

    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Customer get(int id) {
        final String sql = "select * from customer where cumstomer.id = " + id;
        try {
            return jdbcTemplate.queryForObject(sql, customerRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Integer add(Customer customer) {
        final String sql = "INSERT INTO customer(name, surname, email, address, age, phone_number) VALUES (?, ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, customer.getName());
                ps.setString(2, customer.getSurname());
                ps.setString(3, customer.getEmail());
                ps.setString(4, customer.getAddress());
                if (customer.getAge() !=0) {
                    ps.setInt(5, customer.getAge());
                } else {
                    ps.setNull(5, Types.INTEGER);
                }
                ps.setString(6, customer.getPhoneNumber());
                return ps;
            }
        }, keyHolder);
        // Retrieve the generated key after the insert
        if (keyHolder.getKey() !=null) {
            return keyHolder.getKey().intValue();
        }else{
            return  null;
        }
    }


}

