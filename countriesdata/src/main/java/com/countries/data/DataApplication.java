package com.countries.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class DataApplication {

    static CountryList theCountryList;
  

    public static void main(String[] args) {
        theCountryList = new CountryList();
        SpringApplication.run(DataApplication.class, args);


    }



}
