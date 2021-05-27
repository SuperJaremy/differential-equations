package main.io;

import main.Equation;
import main.methods.Methods;

import java.util.Scanner;

public class ConsoleReader {
    public InputData read() {
        Equation equation;
        double condition;
        double leftBorder;
        double rightBorder;
        double step;
        double epsilon;
        Methods method;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите уравнение");
        for (int i = 0; i < Equation.values().length; i++) {
            System.out.println((i + 1) + ". " + Equation.values()[i]);
        }
        int n;
        n = scanner.nextByte();
        equation = Equation.values()[n - 1];
        System.out.println("Введите левую границу отрезка");
        leftBorder = scanner.nextDouble();
        System.out.println("Введите правую границу интервала");
        rightBorder = scanner.nextDouble();
        System.out.println("Введите начальное значение");
        condition = scanner.nextDouble();
        System.out.println("Введите шаг");
        step = scanner.nextDouble();
        System.out.println("Введите точность");
        epsilon = scanner.nextDouble();
        System.out.println("Выберите метод решения");
        for (int i = 0; i < Methods.values().length; i++) {
            System.out.println((i + 1) + ". " + Methods.values()[i]);
        }
        n = scanner.nextByte();
        method = Methods.values()[n - 1];
        return new InputData(equation, condition, leftBorder, rightBorder, step, epsilon, method);
    }
}
