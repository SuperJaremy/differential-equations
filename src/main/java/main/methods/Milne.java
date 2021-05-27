package main.methods;

import main.Equation;


public class Milne extends Method {

    public Milne(Equation equation, double condition, double leftBorder, double rightBorder, double step, double epsilon) {
        super(equation, condition, leftBorder, rightBorder, step, epsilon);
    }

    @Override
    protected void solve() {
        RungeKutta rungeKutta = new RungeKutta(equation, condition, leftBorder, rightBorder, step, epsilon);
        solution = solve(rungeKutta);
        X = rungeKutta.getX();
    }

    private Double[] solve(RungeKutta rungeKutta) {
        Double[] firstValues = rungeKutta.getSolution();
        Double[] Xs = rungeKutta.getX();
        for (int i = 4; i < Xs.length; i++) {
            firstValues[i] = findSolution(firstValues[i - 4], firstValues[i - 3], firstValues[i - 2], firstValues[i - 1], Xs[i - 3], Xs[i - 2], Xs[i - 1], Xs[i]);
        }
        return firstValues;
    }

    private double findSolution(double y_1, double y_2, double y_3, double y_4, double x_2, double x_3, double x_4, double x_5) {
        double y;
        double yCorrect = y_1 + 4 * step / 3 * (2 * equation.f(x_2, y_2) - equation.f(x_3, y_3) + 2 * equation.f(x_4, y_4));
        do {
            y = yCorrect;
            double fForecast = equation.f(x_5, y);
            yCorrect = y_3 + step / 3 * (equation.f(x_3, y_3) + 4 * equation.f(x_4, y_4) + fForecast);
        } while (Math.abs(y - yCorrect) > epsilon);
        return yCorrect;
    }

}
