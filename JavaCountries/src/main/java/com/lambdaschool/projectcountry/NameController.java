package com.lambdaschool.projectcountry;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/data/names")
public class NameController
{

    // localhost:3456/data/names/all
    @GetMapping(value = "/all",
            produces = {"application/json"})
    public ResponseEntity<?> getAllNames()
    {
        ProjectcountryApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(ProjectcountryApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    // localhost:3456/data/names/start/{letter}
    @GetMapping(value = "/start/{letter}",
            produces = {"application/json"})
    public ResponseEntity<?> countryByLetter(@PathVariable char letter)
    {
        ArrayList<Country> rtnCnt =
                ProjectcountryApplication.ourCountryList.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        rtnCnt.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCnt, HttpStatus.OK);
    }


    // localhost:3456/data//names/size/{number}
    @GetMapping(value = "/size/{number}",
                produces = {"application/json"})
    public ResponseEntity<?> countryByNameLength(@PathVariable int number)
    {
        ArrayList<Country> rtnCnt =
                ProjectcountryApplication.ourCountryList.findCountries(c -> c.getName().length() >= number);
        rtnCnt.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCnt, HttpStatus.OK);
    }

}
