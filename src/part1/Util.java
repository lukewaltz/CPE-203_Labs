package part1;

import java.util.HashMap;
import java.util.Map;

import part1.Country;
import part1.Sector;

public class Util {

    public static Integer getYearWithHighestEmissions(Country country){
        double max = 0;
        int maxY = 0;
        for (Map.Entry<Integer, Emission>pairs: country.getEmissions().entrySet()){
            double temp = pairs.getValue().getCH4() + pairs.getValue().getCO2() + pairs.getValue().getN2O();
            if (temp > max) {
                max = temp;
                maxY = pairs.getKey();
            }
        }
    return maxY;
    }

    public static int getYearWithHighestEmissions(Sector sector)
    {
        double max = 0;
        int maxY = 0;
        for (Map.Entry<Integer, Double>pairs: sector.getEmissions().entrySet()){
            double temp = pairs.getValue();
            if (temp > max){
                max = temp;
                maxY = pairs.getKey();
            }
        }
    return maxY;
    }
}
