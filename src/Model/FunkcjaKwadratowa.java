package Model;

import java.util.HashMap;

public class FunkcjaKwadratowa {

    private double a;
    private double b;
    private double c;
    private HashMap<String, Double> map;

    public FunkcjaKwadratowa() {
        a = 0;
        b = 0;
        c = 0;
        map = new HashMap<>();
    }

    public FunkcjaKwadratowa(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.map = new HashMap<String, Double>();
    }

    public Double getWynik(Double x) {
        return a*x*x + b*x + c;
    }

    public Integer getNumOfZeroPoint(Double delta) {
        if(delta > 0 && a != 0)
            return 2;
        else if(delta == 0 && a != 0)
            return 1;
        else return 0;
    }

    public HashMap getZeroPoints () {
        double delta = getDelta();
        map.clear();

        if(delta > 0 && a !=0) {
            Double x1 = (-b - Math.sqrt(delta)) / 2 * a;
            Double x2 = (-b + Math.sqrt(delta)) / 2 * a;
            map.put("X1 ",x1);
            map.put("X2 ",x2);
            return map;
        }
        else if(delta == 0 && a != 0 ) {
            Double x0 = -b/2*a;
            map.put("X0 ",x0);
            return map;
        }
        else
            return map;
    }

    public double getDelta() {
        double delta = b*b - 4*a*c;
        return delta;
    }

    public double getDelta(double a,double b, double c) {
        double delta = b*b - 4*a*c;
        return delta;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {

            if(a == 0) throw new IllegalArgumentException("a == 0");
            this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}

