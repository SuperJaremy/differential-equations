package main.io;

import lombok.Data;
import main.Equation;
import main.methods.Method;
import main.methods.Methods;

@Data
public class InputData {
    private Equation equation;
    private double condition;
    private double leftBorder;
    private double rightBorder;
    private double step;
    private double epsilon;
    private Method method;

    InputData(Equation equation, double condition, double leftBorder, double rightBorder, double step, double epsilon, Methods methods){
        this.equation = equation;
        this.condition = condition;
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
        this.step = step;
        this.epsilon = epsilon;
        method = methods.getMethod(equation, condition, leftBorder, rightBorder, step, epsilon);
    }
}
