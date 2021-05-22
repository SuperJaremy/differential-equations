package main;

import main.methods.RungeKutta;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        RungeKutta method1 = new RungeKutta(Equation.FIRST, -1, 1, 1.5, 0.1, 0.001);
        System.out.println(Arrays.toString(method1.getX()));
        System.out.println(Arrays.toString(method1.getSolution()));
        System.out.println(method1.getProximity());
        System.out.println(method1.isCloseEnough());
    }
}
