package com.projectDB.Shop.db.service.api;

import com.projectDB.Shop.model.Customer;
import org.springframework.lang.Nullable;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomer();
    
    @Nullable
    Customer get(int id);

}
