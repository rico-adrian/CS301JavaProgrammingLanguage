//import statements
//package countrycities;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Map.Entry;

public class countryCities {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        int a = 1;
        String b = "";

        ArrayList<Country> countries = new ArrayList<>();  //all of the countries
        ArrayList<String> listOfCountry = new ArrayList<String>();//filtered countries
        HashSet<String> setCountry = new HashSet<String>();   //filters the countries into no dupes

        try {
            BufferedReader in = new BufferedReader(new FileReader("cities.txt"));
            String str;

            int largeCityCounter = 0;     //Counts the number of large cities  
            int mediumCityCounter = 0;    //Counts the number of med cities 
            int smallCityCounter = 0;     //Counts the number of small cities
            String largestCityName = "";       //Declares the string largestCityName

            //This while loop adds the countries into a list of countries
            while ((str = in.readLine()) != null) {
                String[] details = str.split(" "); //The current line in the file cities
                listOfCountry.add(details[2]);
            }

            //After adding the countries into a list, adds it into a set to remove all
            //the other duplicate countries and moves it back to the arraylist so that
            //we will end up with our list of countries without any duplicates.
            setCountry.addAll(listOfCountry);
            System.out.println(setCountry);
            Iterator<String> it = setCountry.iterator();
            while (it.hasNext()) {
                countries.add(new Country(it.next()));
            }

            //Creates a new buffered reader that reads through the file
            in = new BufferedReader(new FileReader("cities.txt"));
            while ((str = in.readLine()) != null) {
                String[] details = str.split(" "); //The current line in the file cities
                City currentCity = new City(details[0], details[1], details[2], Integer.parseInt(details[3]));
                int offset = 0;
                while (true) {
                    if (countries.get(offset).countryName.equals(details[2])) {
                        break;
                    } else {
                        offset++;
                    }
                }
                int largestCityPopulation = Integer.parseInt(details[3]);           //Converts string into int 
                if (Integer.parseInt(details[3]) > 500000) {                        //Checks if City is Large
                    countries.get(offset).largeCities.add(currentCity);             //Adds to largeCities if it is.
                    largeCityCounter++;                                             //Increments largeCityCounter
                        
                } else if (Integer.parseInt(details[3]) > 100000) {                 //Checks if City is Medium
                    countries.get(offset).mediumCities.add(currentCity);            //Adds to mediumCities if it is.
                    mediumCityCounter++;                                            //Increments mediumCityCounter
                    
                } else if (Integer.parseInt(details[3]) > 20000) {                  //Checks if City is Small
                    countries.get(offset).smallCities.add(currentCity);             //Adds to smallCity if it is.
                    smallCityCounter++;                                             //Increments mediumCityCounter
                }
            }
            //System.out.println("List of countries: " + countries); <~ This is just to check the countries in the list
            
            for (int i = 0; i < countries.size(); i++) {
                //Create new city object to take largest
                City largest = new City("", "", "", 0);
                
                if (countries.get(i).largeCities.size() > 0) {
                    for (City tmp : countries.get(i).largeCities) { //compares the current city to the cities in large city
                        if (largest.population < tmp.population) {  //if the new city is larger than current city, replace
                            largest = tmp;                          //replace
                        }
                    }
                } else if (countries.get(i).mediumCities.size() > 0) {
                    for (City tmp : countries.get(i).mediumCities) {
                        if (largest.population < tmp.population) {
                            largest = tmp;
                        }
                    }

                } else {

                    for (City tmp : countries.get(i).smallCities) {
                        if (largest.population < tmp.population) {
                            largest = tmp;
                        }
                    }
                }
                //Displays information about the country and the cities.
                System.out.println("Country: " + countries.get(i));
                System.out.println("    Largest City: " + largest);
                System.out.println("    Large Cities: " + countries.get(i).largeCities.size());
                System.out.println("    Medium Cities: " + countries.get(i).mediumCities.size());
                System.out.println("    Small Cities:" + countries.get(i).smallCities.size());
                System.out.println("");
                System.out.println(smallCityCounter);

            }

            //This is the part where we interact with the user if they want to obtain something
            //specific in the program.
            Scanner interact = new Scanner(System.in);
            while (true) { //while the user still wants more information
                //Asks the user if they want to access more information
                System.out.println("Anything specific you want to know? Y or N. N to terminate program");
                String ans1 = interact.next();
                if (ans1.equalsIgnoreCase("n") || ans1.equalsIgnoreCase("no")) { //if the user wants to quit
                    return;
                } else if (ans1.equalsIgnoreCase("y") || ans1.equalsIgnoreCase("yes")) {    //If the user wants more
                    System.out.println("List of Countries:" + countries);                   //Prints the list of countries 
                    
                    System.out.println("Enter desired country (input is case sensitive: ");     //Asks for the desired country
                    
                    String ans2 = interact.next(); 
                    
                    if (!setCountry.contains(ans2)) {   //If the user input country is not in the list, display error message.
                        System.out.println(ans2 + " is not in the list.");
                    } else {
                        System.out.println("What is the size of the city? S for small, M for medium, L for large: ");   //Asks the user for the size of desired cities
                        String ans3 = interact.next();
                        //if the user asks for small cities, display small cities of given country.
                        if (ans3.equalsIgnoreCase("s") || ans3.equalsIgnoreCase("small")) {
                            for (City smallCitie : countries.get(0).smallCities) {
                                System.out.println(smallCitie);
                            }
                        //If the user asks for medium cities, display medium cities of given country.
                        } else if (ans3.equalsIgnoreCase("m") || ans3.equalsIgnoreCase("medium")) {
                            for (City mediumCitie : countries.get(0).mediumCities) {
                                System.out.println(mediumCitie);
                            }
                        //If the user asks for large cities, display large cities of given country.
                        } else if (ans3.equalsIgnoreCase("l") || ans3.equalsIgnoreCase("large")) {
                            for (City largeCitie : countries.get(0).largeCities) {
                                System.out.println(largeCitie.toString());
                            }
                        } else {    //Displays error message if user doesn't enter appropriate size
                            System.out.println("Specified size cannot be found.");
                        }
                    }
                } else {        //Displays error message if user does not enter y, yes, n, or no.
                    System.out.println("User Input not recognized.");
                }
            }
        } //Prints out an error if the file is not in the same folder as the class
        catch (FileNotFoundException e) {
            System.out.println("File is not found, please check if cities file"
                    + " is in correct folder.");
            System.exit(-1);
        } catch (IOException e) {
            System.exit(-1);
        }
    }

}
