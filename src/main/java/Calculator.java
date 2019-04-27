import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;

import org.apache.log4j.Logger;

public class Calculator {

    static {
        new DOMConfigurator().doConfigure("src/main/resources/log4j.xml", LogManager.getLoggerRepository());
    }

    private static Logger logger = Logger.getLogger("logger");

    public double addition(double a, double b) {
        logger.info("Addition arguments are: " + a + ", " + b);
        logger.info("Addition result: " + (a + b));
        return a + b;
    }

    public double substraction(double a, double b) {
        logger.info("Substraction arguments are: " + a + ", " + b);
        logger.info("Substraction result: " + (a - b));
        return a - b;
    }

    public double multiplication(double a, double b) {
        logger.info("Multiplication arguments are: " + a + ", " + b);
        logger.info("Multiplication result: " + (a * b));
        return a * b;
    }

    public double division(double a, double b) {
        logger.info("Division arguments are: " + a + ", " + b);
        if (b == 0) {
            logger.error("Division by zero error");
            throw new ArithmeticException();
        }
        logger.info("Division result: " + (a / b));
        return a / b;
    }

    public double getSquareRoot(int number) {
        logger.info("Argument under qsuare root: " + number);
        if (number < 0) {
            logger.error("Negative argument under square root");
            throw new ArithmeticException();
        }
        double result = Math.sqrt(number);
        logger.info("Getting square root result: " + result);
        return result;
    }

    public boolean isPrime(int number) {
        logger.info("Number for check isPrime() method: " + number);
        if (number <= 0) {
            logger.error("Number in isPrime() should be more than zero. Number = " + number);
            throw new IllegalArgumentException();
        }

        if (number > 2 && number % 2 == 0) {
            logger.info("Checking number is not prime");
            return false;
        }

        int sqrt = (int) Math.sqrt(number);
        for (int i = 3; i <= sqrt; i = i + 2) {
            if (number % i == 0) {
                logger.info("Checking number is not prime");
                return false;
            }
        }
        logger.info("Checking number is prime");
        return true;
    }

    public int fibonachi(int number) {
        int result = calculateFibonachiNumber(number);
        logger.info("Number " + number + " in fibonachi sequence is " + result);
        return result;
    }

    private int calculateFibonachiNumber(int number){
        if (number == 1) {
            return 0;
        }
        if (number == 2) {
            return 1;
        } else {
            int result = calculateFibonachiNumber(number - 1) + calculateFibonachiNumber(number - 2);
            return result;
        }
    }

    public int summarizeNumberRow(int[] row) {
        int sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum += row[i];
        }
        logger.info("Array summarize result: " + sum);
        return sum;
    }
}
