package com.countries.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataApplication {

    static CountriesList theCountryList;

    public static void main(String[] args) {
        theCountryList = new CountriesList();
        SpringApplication.run(DataApplication.class, args);


    }



}
