package main;

import java.util.function.DoubleBinaryOperator;

public enum Equation {
    FIRST("y'=y+(1+x)y^2", (x, y) -> y + (1 + x) * Math.pow(y, 2));

    private final DoubleBinaryOperator equation;
    private final String name;

    Equation(String name, DoubleBinaryOperator equation) {
        this.name = name;
        this.equation = equation;
    }

    public double f(double x, double y){
        return  equation.applyAsDouble(x,y);
    }

    @Override
    public String toString(){
        return name;
    }
}
