package main.methods;

import main.Equation;

public abstract class Method {

    protected final Equation equation;
    protected final double condition;
    protected final double leftBorder;
    protected final double rightBorder;
    protected final double step;
    protected final double epsilon;
    protected Double[] solution;
    protected Double[] X;
    public Method(Equation equation, double condition, double leftBorder, double rightBorder, double step, double epsilon){
        this.equation = equation;
        this.condition = condition;
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
        this.step = step;
        this.epsilon = epsilon;
        solve();
    }

    protected abstract void solve();

    public Double[] getX() {
        return X;
    }

    public Double[] getSolution() {
        return solution;
    }
}
