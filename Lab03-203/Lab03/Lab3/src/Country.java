//represents a country and its emissions over time
//each country is represented by its name(String), and Map from year(Int) to emissions(emission)

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.abs;

public class Country implements GreenhouseGasEmitter{
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

    @Override
    public double getTotalEmissionsInYear(int year){
        Emission curEms = this.getEmissions().get(year);
        return curEms.getCH4() + curEms.getCO2() + curEms.getN2O();
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

    public static Country countryWithHighestCH4InYear(List<Country> countries, int year)
    {
        double highCH4 = 0;
        int highCountry = 0;
        for (int i = 0; i < countries.size(); i++){

            if (countries.get(i).getEmissions().get(year).getCH4() > highCH4){
                highCH4 = countries.get(i).getEmissions().get(year).getCH4();
                highCountry = i;
            }
        }
        System.out.println(highCH4);
        //System.out.println(countries.get(highCountry).getName());
        return countries.get(highCountry);
    }

    public static Country countryWithHighestChangeInEmissions(List<Country> countries, int startYear, int endYear){
        Country maxC = new Country("Null", new HashMap<>());
        double maxChange = 0;
        double startSum = 0;
        double endSum;

        for (Country country: countries){
            for(Map.Entry<Integer, Emission> each: country.getEmissions().entrySet()){
                int cur_year = each.getKey();
                if(startYear == cur_year){
                    startSum = each.getValue().getCH4() + each.getValue().getCO2() + each.getValue().getN2O();
                }
                else if(endYear == cur_year) {
                    endSum = each.getValue().getCH4() + each.getValue().getCO2() + each.getValue().getN2O();
                    double curChange = abs(endSum - startSum);
                    if (maxChange < curChange){
                        maxC = country;
                        maxChange = curChange;
                    }
                }
            }

        }
        System.out.println(maxChange);
        System.out.println(maxC.getName());
        return maxC;
    }
}
