package main;

import main.io.ConsoleReader;
import main.io.ConsoleWriter;
import main.io.InputData;
import main.methods.Method;


public class Main {
    public static void main(String[] args){
        ConsoleReader reader = new ConsoleReader();
        InputData data = reader.read();
        Method method = data.getMethod();
        ChartDrawer drawer = new ChartDrawer(method.getX(), method.getSolution(), data.getEquation(), data.getLeftBorder(), data.getCondition());
        ConsoleWriter writer = new ConsoleWriter();
        writer.write(method);
//        RungeKutta method1 = new RungeKutta(Equation.FOURTH, 1, 1, 3, 0.1, 0.001);
//        System.out.println(Arrays.toString(method1.getX()));
//        System.out.println(Arrays.toString(method1.getSolution()));
//        Milne method2 = new Milne(Equation.FOURTH, 1, 1, 3, 0.1, 0.001);
//        System.out.println(Arrays.toString(method2.getSolution()));
//        ChartDrawer drawer = new ChartDrawer(method1.getX(), method1.getSolution(), Equation.FOURTH, 1, 1);
//        ChartDrawer drawer1 = new ChartDrawer(method2.getX(), method2.getSolution(), Equation.FOURTH, 1 ,1);
    }
}
