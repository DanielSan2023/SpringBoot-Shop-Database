package com.projectDB.Shop.db.service.api;

import com.projectDB.Shop.model.Merchant;
import org.springframework.lang.Nullable;

import java.util.List;

public interface MerchantService {
    List<Merchant> getMerchants();

    @Nullable
    Merchant get(int id);

    @Nullable
    Integer add(Merchant merchant); // returns generated id
}
