package com.lambdaschool.projectcountry;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/data/age")
public class AgeController
{

//    // localhost:3456/data/age/age/{age}
    @GetMapping(value = "/age/{age}",
    produces = "application/json")
    public ResponseEntity<?> getMedianAge(@PathVariable int age)
    {
        ArrayList<Country> rtnCnt = ProjectcountryApplication.ourCountryList.findCountries(c->c.getMedianAge() >= age);
        rtnCnt.sort((c1,c2)->c1.getMedianAge()-c2.getMedianAge());
        return new ResponseEntity<>(rtnCnt, HttpStatus.OK);

    }


//// localhost:3456/data/age/min
    @GetMapping(value = "/min",
    produces = "application/json")
    public ResponseEntity<?> getLowestMedianAge()
    {
        ArrayList<Country> rtnCnt = ProjectcountryApplication.ourCountryList.countryList;
        rtnCnt.sort((c1,c2)->c1.getMedianAge()-c2.getMedianAge());
        return new ResponseEntity<>(rtnCnt.get(0), HttpStatus.OK);

    }

    // localhost:3456/data/age/max
    @GetMapping(value = "/max",
            produces = "application/json")
    public ResponseEntity<?> getHighestMedianAge()
    {
        ArrayList<Country> rtnCnt = ProjectcountryApplication.ourCountryList.countryList;
        rtnCnt.sort((c1,c2)->c2.getMedianAge()-c1.getMedianAge());
        return new ResponseEntity<>(rtnCnt.get(0), HttpStatus.OK);

    }

//    // localhost:3456/data/age/median
//    @GetMapping(value="/median",
//            produces = {"application/json"})
//    public ResponseEntity<?> medianAge()
//    {
//
//    }

}
