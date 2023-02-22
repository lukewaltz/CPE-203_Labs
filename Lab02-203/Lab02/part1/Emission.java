package part1;

//emissions class represents emissions of CO2, N20, and CH4 as doubles

public class Emission {
    //instance variables (must be private)
    private double co2;
    private double n2o;
    private double ch4;

    //constructor - takes doubles for co2, n2o, ch4
    public Emission(double co2, double n2o, double ch4){
        this.co2 = co2;
        this.n2o = n2o;
        this.ch4 = ch4;
    }

    //getters - names are in test cases
    public double getCO2(){
        return co2;
    }

    public double getCH4(){
        return ch4;
    }

    public double getN2O(){
        return n2o;
    }

    //any additional methods must be private


}
