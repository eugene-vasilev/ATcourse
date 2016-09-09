package com.company.bsu;

/**
 * Created by evasilev on 09-Sep-16.
 */
public class Calculator {
    private double a, b;

    Calculator(double q,double w){
        a=q;
        b=w;
    }

    public double divide(){
        return a/b;
    }
    public double multiply(){
        return a*b;
    }
    public double sum(){
        return a+b;
    }
    public double deduct(){
        return a-b;
    }
}
