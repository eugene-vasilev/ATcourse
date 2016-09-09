package com.company.bsu;

import java.util.Scanner;

public class Main {

    public static int showMsg() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Select an option:");
        System.out.println("1 - Sum");
        System.out.println("2 - Deduct");
        System.out.println("3 - Multiply");
        System.out.println("4 - Divide");
        System.out.println("5 - Other numbers");
        System.out.println("6 - Exit");
        int operation = scan.nextInt();
        return operation;
    }

    public static void calculate() {
        Scanner scan = new Scanner(System.in);
        double firstNumber, secondNumber;
        System.out.println("Please enter first number:");
        firstNumber = scan.nextDouble();
        System.out.println("Please enter second number:");
        secondNumber = scan.nextDouble();
        selectAction(firstNumber, secondNumber);
    }

    public static void showResult(double result) {
        System.out.printf("Result : %f\n", result);
        System.out.println("==================");
    }

    public static void selectAction(double firstNumber, double secondNumber) {
        Calculator myCalc = new Calculator(firstNumber, secondNumber);
        double result=0;
        switch (showMsg()) {
            case 1:
                result = myCalc.sum();
                break;
            case 2:
                result = myCalc.deduct();
                break;
            case 3:
                result = myCalc.multiply();
                break;
            case 4:
                result = myCalc.divide();
                break;
            case 5:
                System.out.println("==================");
                calculate();
                break;
            case 6:
                System.out.println("Thanks for using our calculator!:)");
                System.exit(0);
            default:
                System.out.println("No such operation");
                selectAction(firstNumber,secondNumber);

        }
        showResult(result);
        selectAction(firstNumber, secondNumber);
    }

    public static void main(String[] args) {
        calculate();
    }

}