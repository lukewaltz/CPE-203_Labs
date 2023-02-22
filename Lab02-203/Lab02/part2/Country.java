package part2;

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

    public int getYearWithHighestEmissions(){
        double max = 0;
        int maxY = 0;
        for (Map.Entry<Integer, Emission>pairs: this.getEmissions().entrySet()){
            double temp = pairs.getValue().getCH4() + pairs.getValue().getCO2() + pairs.getValue().getN2O();
            if (temp > max) {
                max = temp;
                maxY = pairs.getKey();
            }
        }
        return maxY;
    }
}
