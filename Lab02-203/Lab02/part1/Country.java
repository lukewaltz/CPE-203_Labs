package part1;

//represents a country and its emissions over time
//each country is represented by its name(String), and Map from year(Int) to emissions(emission)

import java.util.HashMap;
import java.util.Map;

public class Country {
    //instance variables
    private String name;
    private Map<Integer, Emission> emissionByYear;

    //constructor
    public Country(String name, Map<Integer, Emission> emissionByYear){
        this.name = name;
        this.emissionByYear = emissionByYear;
    }

    //getter
    public String getName(){
        return name;
    }

    public Map<Integer, Emission> getEmissions(){
        return emissionByYear;
    }
}
