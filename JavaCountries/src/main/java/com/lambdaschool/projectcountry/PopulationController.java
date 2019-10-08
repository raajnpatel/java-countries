package com.lambdaschool.projectcountry;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/data/population")
public class PopulationController
{

    // localhost:3456/data/population/size/{people}
    @GetMapping(value = "/size/{people}",
            produces = "application/json")
    public ResponseEntity<?> getCountriesByNameLength(@PathVariable long people)
    {
        ArrayList<Country> rtnCnt =
                ProjectcountryApplication.ourCountryList.findCountries(c -> c.getPopulation() >= people);
        rtnCnt.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCnt, HttpStatus.OK);
    }


    // localhost:3456/data/population/max
    @GetMapping(value = "/max",
            produces = "application/json")
    public ResponseEntity<?> findLargestPopulation()
    {
        ArrayList<Country> rtnCnt = ProjectcountryApplication.ourCountryList.countryList;

        rtnCnt.sort((c1,c2)->(int)(c2.getPopulation() - c1.getPopulation()));

        return new ResponseEntity<>(rtnCnt.get(0), HttpStatus.OK);
    }

    // localhost:3456/data/population/min
    @GetMapping(value = "/min",
            produces = "application/json")
    public ResponseEntity<?> findLowestPopulation()
    {
        ArrayList<Country> rtnCnt = ProjectcountryApplication.ourCountryList.countryList;

        rtnCnt.sort((c1,c2)->(int)(c1.getPopulation() - c2.getPopulation()));

        return new ResponseEntity<>(rtnCnt.get(0), HttpStatus.OK);
    }
}