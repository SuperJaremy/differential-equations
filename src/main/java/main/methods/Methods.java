package main.methods;

import main.Equation;

public enum Methods {
    RUNGE_KUTTA(RungeKutta::new),
    MILNE(Milne::new);

    private final DataToMethod dataToMethod;

    Methods(DataToMethod dataToMethod){
        this.dataToMethod = dataToMethod;
    }

    public Method getMethod(Equation equation, double condition, double leftBorder, double rightBorder, double step, double epsilon){
        return dataToMethod.apply(equation, condition, leftBorder, rightBorder, step, epsilon);
    }

    private interface DataToMethod{
        Method apply(Equation equation, double condition, double leftBorder, double rightBorder, double step, double epsilon);
    }
}
