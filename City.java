/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package countrycities;
//import statements

//Miguel Santos
//Rico Adrian
//CS301
//Project 2
//November 2, 2016
import java.util.*;
import java.io.*;

public class City {
    
    
    public String countryName;
    protected String province;
    protected String department;
    protected String country;
    protected int population;

    public City(String province, String department, String country, int population) {
        this.countryName = countryName;
        this.province = province;
        this.department = department;
        this.country = country;
        this.population = population;
    }

    

    public int population() {
        return population;
    }

    @Override
    public String toString() {
        return province+", ["+population+"]";
    }

}
