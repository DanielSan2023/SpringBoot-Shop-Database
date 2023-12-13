package com.projectDB.Shop.db.repository;

import com.projectDB.Shop.db.mapper.ProductRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProductRepository {
    private JdbcTemplate jdbcTemplate;
    private final ProductRowMapper productRowMapper = new ProductRowMapper();


}
