package com.lambdaschool.projectcountry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectcountryApplication
{
    public static CountryList ourCountryList;
    public static CountryList countryNames;

    public static void main(String[] args)
    {
        ourCountryList = new CountryList();
        SpringApplication.run(ProjectcountryApplication.class, args);
    }

}
