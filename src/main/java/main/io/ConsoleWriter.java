package main.io;

import main.methods.Method;

public class ConsoleWriter {
    public void write(Method method){
        for (int i = 0; i < method.getX().length; i++) {
            System.out.println("x: "+method.getX()[i]+" y: "+method.getSolution()[i]);
        }
    }
}
