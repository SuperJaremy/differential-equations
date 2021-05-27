package main;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

public enum Equation {
    FIRST("y' = y + (1 + x)y^2", (x, y) -> y + (1 + x) * Math.pow(y, 2), (x, y) -> -Math.exp(x) / y - Math.exp(x) * x, (c, x) -> -Math.exp(x) / (c + Math.exp(x) * x)),
    SECOND("y' = x^2 - 2y", (x, y) -> Math.pow(x, 2) - 2 * y, (x, y) -> -(Math.pow(x, 2) / 2.0 - x / 2.0 + 0.25 - y) * Math.exp(2.0 * x), (c, x) -> c * Math.exp(-2.0 * x) + Math.pow(x, 2) / 2.0 - x / 2.0 + 0.25),
    THIRD("y' = y + x*exp(x)",(x,y) -> y+x*Math.exp(x), (x, y) -> (y-Math.exp(x)*Math.pow(x,2)/2.0)/Math.exp(x), (c, x) -> c*Math.exp(x)+Math.exp(x)*Math.pow(x,2)/2.0),
    FOURTH("xy' = y*ln(y/x)", (x,y) -> y*Math.log(y/x)/x, (x,y) -> (Math.log(y/x)-1)/x, (c, x) -> x*Math.exp(c*x+1));

    private final DoubleBinaryOperator equation;
    private final String name;
    private final DoubleBinaryOperator cExpressed;
    private final DoubleBinaryOperator exactSolution;

    Equation(String name, DoubleBinaryOperator equation, DoubleBinaryOperator cExpressed, DoubleBinaryOperator exactSolution) {
        this.name = name;
        this.equation = equation;
        this.cExpressed = cExpressed;
        this.exactSolution = exactSolution;
    }

    public double f(double x, double y) {
        return equation.applyAsDouble(x, y);
    }

    public double getSolution(double x, double x_condition, double y_condition) {
        double c = cExpressed.applyAsDouble(x_condition, y_condition);
        return exactSolution.applyAsDouble(c, x);
    }

    @Override
    public String toString() {
        return name;
    }
}
