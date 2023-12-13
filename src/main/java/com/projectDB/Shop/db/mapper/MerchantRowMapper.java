package com.projectDB.Shop.db.mapper;


import com.projectDB.Shop.model.Merchant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MerchantRowMapper implements RowMapper {
    @Override
    public Merchant mapRow(ResultSet rs, int rowNum) throws SQLException {
        Merchant merchant = new Merchant();
        merchant.setId(rs.getInt("id"));
        merchant.setName(rs.getString("name"));
        merchant.setEmail(rs.getString("email"));
        merchant .setAddress(rs.getString("address"));
        return merchant;
    }

}
