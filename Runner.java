package Testovoe;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберете калькулятор тип калькулятора, A - арабский, R - римский");
        String calculatorType = readCalculatorTapy(scanner);
        int firstNumbrer = 0;
        int secondNamber = 0;
        if (calculatorType.equals("R")) {
            System.out.println("Введите первое число");
            firstNumbrer = readRomeNumber(scanner).arabicNumber;
            System.out.println("Введите второе число");
            secondNamber = readRomeNumber(scanner).arabicNumber;


        } else if (calculatorType.equals("A")) {
            System.out.println("Введите первое число");
            firstNumbrer = readArabicNumber(scanner);
            System.out.println("Введите второе число");
            secondNamber = readArabicNumber(scanner);

        }


        System.out.println("Введите математическую аперацию");
        String operation = getOperation(scanner);
        Converter converter = new Converter();


        Calculator calculator = new Calculator();
        int result = 0;
        if (operation.equals("+")) {
            result = calculator.add(firstNumbrer, secondNamber);
        } else if (operation.equals("*")) {
            result = calculator.mutiplication(firstNumbrer, secondNamber);
        } else if (operation.equals("-")) {
            result = calculator.minus(firstNumbrer,secondNamber);
        } else if (operation.equals("/")) {
            result = calculator.division(firstNumbrer, secondNamber);
        } else {
            System.out.println("Ошибка! Не верная операция");
        }
        if (calculatorType.equals("R")) {
            String romanResult = converter.intToRoman(result);;
            System.out.println(romanResult);


        }else{
            System.out.println(result);
        }


        scanner.close();

    }


    public static int readArabicNumber(Scanner scanner) {
        String firstValue;
        int firstNumber = -1;
        while (scanner.hasNextLine()) {
            try {
                firstValue = scanner.nextLine();
               firstNumber = Integer.parseInt(firstValue);
                if (firstNumber >= 0 && firstNumber < 10) break;
                else System.out.println("ОШИБКА! Неверное значение");
            } catch (Exception ex) {
                System.out.println("ОШИБКА! Неверное значение");
            }
        }
        return firstNumber;
    }

    public static RomeNumber readRomeNumber(Scanner scanner) {
        String romeNumber = "";
        RomeNumber[] romeNumbers = RomeNumber.values();
        while (scanner.hasNextLine()) {
                romeNumber = scanner.nextLine();
                for (int i = 0; i < romeNumbers.length; i++) {
                    if (romeNumber.equals(romeNumbers[i].name())) {
                        return romeNumbers[i];
                    }
                }
            System.out.println("Ошибка! Неверное значение");
        }
        return null;
    }


    public static String getOperation(Scanner scanner) {
        String operation = "";
        while (scanner.hasNextLine()) {
            operation = scanner.nextLine();
            if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) break;
            else System.out.println("Ошибка! Неверный тип операции");

        }
        return operation;
    }

    public static String readCalculatorTapy(Scanner scanner) {
        String calculatorTapy;
        calculatorTapy = "";
        while (scanner.hasNextLine()) {
            calculatorTapy = scanner.nextLine();
            if (calculatorTapy.equals("A") || calculatorTapy.equals("R")) break;
            else System.out.println("Неверный тип калькулятора");

        }
        return calculatorTapy;
    }

}




