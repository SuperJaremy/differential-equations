package main.methods;

import main.Equation;

import java.util.ArrayList;
import java.util.List;

public class RungeKutta extends Method{


    private double proximity;
    private boolean closeEnough;
    private final double ORDER = 4;

    public RungeKutta(Equation equation, double condition, double leftBorder, double rightBorder, double step, double epsilon) {
        super(equation, condition, leftBorder, rightBorder, step, epsilon);
    }

    @Override
    protected void solve() {
        List<Double> Xs = new ArrayList<>();
        long stepCount = Math.round((rightBorder - leftBorder) / step);
        double left = leftBorder;
        for (long i = 0; i <= stepCount; i++) {
            Xs.add(left);
            left += step;
        }
        X = Xs.toArray(new Double[0]);
        solution = solve(step);
        Double[] Runge = solve(step / 2);
        proximity = Math.abs((Runge[Runge.length - 1] - solution[solution.length - 1]) / (Math.pow(2, ORDER) - 1));
        closeEnough = proximity <= epsilon;
    }

    private Double[] solve(double step) {
        List<Double> results = new ArrayList<>();
        results.add(condition);
        int counter = 1;
        double x = leftBorder;
        long stepCount = Math.round((rightBorder - leftBorder) / step);
        for (long i = 0; i < stepCount ;i ++) {
            results.add(findSolution(x, results.get(counter - 1), step));
            counter++;
            x+=step;
        }
        return results.toArray(new Double[0]);
    }

    private double findSolution(double x, double y, double h) {
        double k_1 = h * equation.f(x, y);
        double k_2 = h * equation.f(x + h / 2, y + k_1 / 2);
        double k_3 = h * equation.f(x + h / 2, y + k_2 / 2);
        double k_4 = h * equation.f(x + h, y + k_3);
        return y + (k_1 + 2 * k_2 + 2 * k_3 + k_4) / 6;
    }

    public boolean isCloseEnough() {
        return closeEnough;
    }

    public double getProximity() {
        return proximity;
    }
}
