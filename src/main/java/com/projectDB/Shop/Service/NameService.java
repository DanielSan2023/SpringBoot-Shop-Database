package com.projectDB.Shop.Service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class NameService {
    @Value("${name}")
    private String name;

    @PostConstruct  // After startApp
    private void sayMyName() {
        System.out.println(name);
    }


}
