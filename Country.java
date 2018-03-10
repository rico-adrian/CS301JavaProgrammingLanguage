/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package countrycities;
//import statements

import java.util.*;

public class Country {

    public String countryName;
    protected ArrayList<City> largeCities; // > 500K 
    protected ArrayList<City> mediumCities; // > 100K 
    protected ArrayList<City> smallCities; // > 20K

    public Country(String s) {
        this.countryName = s;
        largeCities = new ArrayList<City>();
        mediumCities = new ArrayList<City>();
        smallCities = new ArrayList<City>();
        int i=largeCities.size()+mediumCities.size()+smallCities.size();
        
    }
    
  

    @Override
    public String toString() {
        return countryName;
    }
}
