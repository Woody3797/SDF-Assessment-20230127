package src;

import java.io.Console;

public class Main {

    public static void main(String[] args) {

        double last = 0;
        String input = "";
        double result = 0;
        double num1 = 0;
        double num2 = 0;

        Console cons = System.console();

        System.out.println("Welcome.");

        while (!input.contains("exit")) {
            try {
                input = cons.readLine("> ");

                if (input.contains("exit")) {
                    System.out.print("Bye bye");
                    System.exit(0);
                }

                String[] inputArr = input.trim().split(" ");

                if (inputArr[0].equals("$last")) {
                    num1 = last;
                } else {
                    num1 = Double.parseDouble(inputArr[0]);
                }
                if (inputArr[2].equals("$last")) {
                    num2 = last;
                } else {
                    num2 = Double.parseDouble(inputArr[2]);
                }
                String operator = inputArr[1];

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        last = result;
                        break;
                    case "-":
                        result = num1 - num2;
                        last = result;
                        break;
                    case "/":
                        result = num1 / num2;
                        last = result;
                        break;
                    case "*":
                        result = num1 * num2;
                        last = result;
                        break;
                    default:
                        System.out.println("invalid input, try again");
                        break;
                }

                if (result % 1 != 0) {
                    System.out.printf("%.5f\n", result);
                } else {
                    System.out.printf("%.0f\n", result);
                }
            } catch (Exception e) {
                continue;
            }
        }
    }
}
