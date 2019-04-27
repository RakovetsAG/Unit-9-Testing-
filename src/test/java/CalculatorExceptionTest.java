import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorExceptionTest {

    private Calculator calculator;

    @Before
    public void initCalculator() {
        calculator = new Calculator();
    }

    @After
    public void resetCalculator() {
        calculator = null;
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZeroTest() {
        calculator.division(5, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void getNegativeArgumentSquareRootTest() {
        calculator.getSquareRoot(-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isNegativeArgumentPrimeTest() {
        calculator.isPrime(-5);
    }
}
