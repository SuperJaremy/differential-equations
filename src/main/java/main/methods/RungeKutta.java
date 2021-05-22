package main.methods;

import main.Equation;

import java.util.ArrayList;
import java.util.List;

public class RungeKutta {

    private final Equation equation;
    private final double condition;
    private final double leftBorder;
    private final double rightBorder;
    private final double step;
    private final double epsilon;
    private Double[] solution;
    private Double[] X;
    private double proximity;
    private boolean closeEnough;
    private final double ORDER = 4;

    public RungeKutta(Equation equation, double condition, double leftBorder, double rightBorder, double step, double epsilon){
        this.equation = equation;
        this.condition = condition;
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
        this.step = step;
        this.epsilon = epsilon;
        solve();
    }

    private void solve() {
        List<Double> Xs = new ArrayList<>();
        for (double i = leftBorder; i < rightBorder ; i+=step) {
            Xs.add(i);
        }
        X = Xs.toArray(new Double[0]);
        solution = solve(equation, condition, leftBorder, rightBorder, step);
        Double[] Runge = solve(equation, condition, leftBorder, rightBorder, step/2);
        proximity = Math.abs((Runge[Runge.length - 1] - solution[solution.length - 1])/(Math.pow(2,ORDER)-1));
        closeEnough = proximity <= epsilon;
    }

    private Double[] solve(Equation equation, double condition, double leftBorder, double rightBorder, double step){
        List<Double> results = new ArrayList<>();
        results.add(condition);
        int counter = 1;
        for (double i = leftBorder; i < rightBorder; i += step) {
            results.add(findSolution(equation, i, results.get(counter - 1), step));
            counter++;
        }
        return results.toArray(new Double[0]);
    }

    private double findSolution(Equation equation, double x, double y, double h) {
        double k_1 = h * equation.f(x, y);
        double k_2 = h * equation.f(x + h / 2, y + k_1 / 2);
        double k_3 = h * equation.f(x + h / 2, y + k_2 / 2);
        double k_4 = h * equation.f(x + h, y + k_3);
        return y + (k_1 + 2 * k_2 + 2 * k_3 + k_4) / 6;
    }

    public Double[] getX() {
        return X;
    }

    public Double[] getSolution(){
        return solution;
    }

    public boolean isCloseEnough() {
        return closeEnough;
    }

    public double getProximity() {
        return proximity;
    }
}
