import Converter.Converter;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "*", "/"};
        String[] regexActions = {"\\+", "-", "\\*", "/"};
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите два числа: ");
        String exp = sc.nextLine();
        int num1;
        int num2;
        int actionsIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if(exp.contains(actions[i])){
                actionsIndex = i;
                break;
            }
        }
        if(actionsIndex==-1){
            try {
                throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("формат математической операции не удовлетворяет заданию - выбор оператора (+, -, /, *)");
                return;
            }
        }
        String[] data = exp.split(regexActions [actionsIndex]);
        if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
            boolean isRoman = converter.isRoman(data[0]);

            if (isRoman) {
                num1 = converter.romanToInt(data[0]);
                num2 = converter.romanToInt(data[1]);

            }
            else {

                num1 = Integer.parseInt(data[0]);
                num2 = Integer.parseInt(data[1]);

            }
            int res;
            switch (actions[actionsIndex]) {
                case "+":
                    res = num1 + num2;
                    break;
                case "-":
                    res = num1 - num2;
                    break;
                case "*":
                    res = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Ой-ой, все плохо -_-");
                        return;
                    } else {
                        res = num1 / num2;
                        break;
                    }
                default: {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                        return;
                    }
                }
            }
            if (num1>10 || num2>10) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("формат математической операции не удовлетворяет заданию - числа от 1 до 10");
                    return;
                }
            }
            if (isRoman) System.out.println(converter.intToRoman(res));
            else System.out.println(res);
        }
        else {
            try {
                throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("используются одновременно разные системы счисления");
            }
        }
    }
}

