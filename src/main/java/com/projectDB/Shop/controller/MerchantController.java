package com.projectDB.Shop.controller;

import com.projectDB.Shop.db.service.api.MerchantService;
import com.projectDB.Shop.model.Merchant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    private final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }


    @PostMapping("id")
    public ResponseEntity add(@RequestBody Merchant merchant){
        Integer id = merchantService.add(merchant);
        if(id!=null){
            return new ResponseEntity<>(merchant,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable("id") int id) {
        Merchant merchant = merchantService.get(id);
        if (merchant != null) {
            return new ResponseEntity<>(merchant, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity getAll() {
        List<Merchant> merchantList = merchantService.getMerchants();
        return new ResponseEntity<>(merchantList, HttpStatus.OK);
    }


}
