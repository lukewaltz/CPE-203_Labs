package part2;

//represents a sector of industry and its GLOBAL emissions (sum)
//represented by name(String) map of year(int) to emissions(Double)

import java.util.HashMap;
import java.util.Map;

public class Sector {
    //instance variables
    private String name;
    private Map<Integer, Double> gEmissions;

    //constructor
    public Sector(String name, Map<Integer, Double> gEmissions){
        this.name = name;
        this.gEmissions = gEmissions;
    }

    //getter
    public String getName(){
        return name;
    }

    public Map<Integer, Double> getEmissions(){
        return gEmissions;
    }

    public int getYearWithHighestEmissions()
    {
        double max = 0;
        int maxY = 0;
        for (Map.Entry<Integer, Double>pairs: this.getEmissions().entrySet()){
            double temp = pairs.getValue();
            if (temp > max){
                max = temp;
                maxY = pairs.getKey();
            }
        }
        return maxY;
    }
}
