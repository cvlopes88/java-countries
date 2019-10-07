package com.countries.data;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/data")
public class CountryDatas {
    @GetMapping(value = "/names", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries() {

        DataApplication.theCountryList.countryList.sort((i1, i2) -> i1.getName().compareToIgnoreCase(i2.getName()));

        return new ResponseEntity<>(DataApplication.theCountryList.countryList, HttpStatus.OK);
    }
//
//    @GetMapping(value = "/names/start/{letter}",
//            produces = {"application/json"})
//    public ResponseEntity<?> getCountryByLetter(
//            @PathVariable char letter) {
//
//    }
}