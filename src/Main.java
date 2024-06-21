import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String raw_exp = scanner.nextLine();
            if ("quit".equalsIgnoreCase(raw_exp)) break;

            String[] expr = raw_exp.split(" ");
            if (expr.length != 3) {
                throw new IllegalArgumentException("Input does not satisfy language rules: " + raw_exp);
            }
            try {
                String operator = expr[0];
                double oper1 = Double.parseDouble(expr[1]);
                double oper2 = Double.parseDouble(expr[2]);

                double result = evaluate(operator, oper1, oper2);
                System.out.println(result);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    private static double evaluate(String operator,double oper1,double oper2)
    {
        switch (operator)
        {
            case "ADD":
                return oper1+oper2;
            case "SUB":
                return oper1-oper2;
            case "MUL":
                return oper1*oper2;
            case "DIV":
                if(oper2==0)
                {
                    throw  new IllegalArgumentException("Division on zero is not allowed");
                }
                return oper1/oper2;
            case "%":
                return oper1%oper2;
            case "^":
                return Math.pow(oper1,oper2);
            default:
                throw new UnsupportedOperationException("Unsupported operation: "+ operator);
        }
    }
    }
