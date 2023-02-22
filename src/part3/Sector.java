package part3;

//represents a sector of industry and its GLOBAL emissions (sum)
//represented by name(String) map of year(int) to emissions(Double)

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.abs;

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

    public static Sector sectorWithBiggestChangeInEmissions(List<Sector> sectors, int startYear, int endYear){
        Sector maxS = new Sector("Null", new HashMap<>());
        double eAvg = 0;
        double totalEmInRange = 0;

        for (Sector sector: sectors){
            for(Map.Entry<Integer, Double> each: sector.getEmissions().entrySet()){
                int cur_year = each.getKey();
                if(cur_year >= startYear & cur_year <= endYear) {
                    totalEmInRange += each.getValue();
                }
            }
            double curAvg = totalEmInRange / (endYear - startYear + 1);
            totalEmInRange = 0;
            if (eAvg < curAvg){
                maxS = sector;
                eAvg = curAvg;
            }
        }
        System.out.println(eAvg);
        System.out.println(maxS.getName());
        return maxS;
    }
}
