package com.projectDB.Shop.db.service.api;

import com.projectDB.Shop.model.Customer;
import org.springframework.lang.Nullable;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    @Nullable
    Customer get(int id);//We can check ID if contains in DB, If no, return null

    @Nullable
    Integer add(Customer customer); // return generated id;
}
