package com.countries.data;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.ArrayList;

@RestController
@RequestMapping("/data")
public class CountryDatas {
    @GetMapping(value = "/names", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries() {

        DataApplication.theCountryList.countryList.sort((i1, i2) -> i1.getName().compareToIgnoreCase(i2.getName()));

        return new ResponseEntity<>(DataApplication.theCountryList.countryList, HttpStatus.OK);
    }

    @GetMapping(value = "names/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getAllCountriesByLetter(@PathVariable String letter){
        ArrayList<Country> tempList =  DataApplication.theCountryList.findCountries(c -> letter.equalsIgnoreCase(c.getName().substring(0,1)));
        tempList.sort((c1,c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(tempList, HttpStatus.OK);
    }


    @GetMapping(value = "names/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getCountryByNameSize(@PathVariable int number){
        ArrayList<Country> tempList = DataApplication.theCountryList.findCountries(c -> c.getName().length() >= number );
        tempList.sort((c1,c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(tempList, HttpStatus.OK);
    }


    @GetMapping(value = "population/size/{people}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByPopulationSize(@PathVariable int people){
        return new ResponseEntity<>(DataApplication.theCountryList.findCountries(c -> c.getPopulation() >= people ), HttpStatus.OK);
    }


    @GetMapping(value = "population/min", produces = {"application/json"})
    public ResponseEntity<?> getCountryBySmallestPopulation(){
        DataApplication.theCountryList.countryList.sort((c1,c2) -> c1.getPopulation() - c2.getPopulation() );
        return new ResponseEntity<>(DataApplication.theCountryList.countryList.get(0), HttpStatus.OK);
    }


    @GetMapping(value = "population/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryByLargestPopulation(){
        DataApplication.theCountryList.countryList.sort((c1,c2) -> c2.getPopulation() - c1.getPopulation() );
        return new ResponseEntity<>(DataApplication.theCountryList.countryList.get(0), HttpStatus.OK);
    }


    @GetMapping(value = "age/age/{age}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByMedianAge(@PathVariable int age){
        return new ResponseEntity<>(DataApplication.theCountryList.findCountries(c -> c.getMedianage() >= age ), HttpStatus.OK);
    }


    @GetMapping(value = "age/min", produces = {"application/json"})
    public ResponseEntity<?> getCountryBySmallestMedianAge(){
        DataApplication.theCountryList.countryList.sort((c1,c2) -> c1.getMedianage() - c2.getMedianage() );
        return new ResponseEntity<>(DataApplication.theCountryList.countryList.get(0), HttpStatus.OK);
    }


    @GetMapping(value = "age/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryByLargestMedianAge(){
        DataApplication.theCountryList.countryList.sort((c1,c2) -> c2.getMedianage() - c1.getMedianage() );
        return new ResponseEntity<>(DataApplication.theCountryList.countryList.get(0), HttpStatus.OK);
    }


}