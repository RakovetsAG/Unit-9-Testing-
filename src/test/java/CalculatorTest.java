import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(NumberRowSupplier.class)
public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void initCalculator() {
        calculator = new Calculator();
    }

    @After
    public void resetCalculator() {
        calculator = null;
    }

    @Test
    public void additionTest() {
        double testResult = calculator.addition(5, 4);
        assertEquals(9, testResult, 0);
    }

    @Test
    public void substractionTest() {
        double testResult = calculator.substraction(5, 4);
        assertEquals(1, testResult, 0);
    }

    @Test
    public void multiplicationTest() {
        double testResult = calculator.multiplication(3, 4);
        assertEquals(12, testResult, 0);
    }

    @Test
    public void divisionTest() {
        double testResult = calculator.division(6, 3);
        assertEquals(2, testResult, 0);
    }

    @Test
    public void getSquareRootTest() {
        double testResult = calculator.getSquareRoot(100);
        assertEquals(10, testResult, 0);
    }


    @Test(timeout = 20)
    public void fibonachiTest() {
        int testResult = calculator.fibonachi(8);
        assertEquals(13, testResult);
    }

    @Test(timeout = 20)
    public void isPrimeTrueTest() {
        boolean testResult = calculator.isPrime(1);
        assertTrue(testResult);
    }

    @Test(timeout = 20)
    public void isPrimeTrueTest2() {
        boolean testResult = calculator.isPrime(997);
        assertTrue(testResult);
    }

    @Test(timeout = 20)
    public void isPrimeFalseTest() {
        boolean testResult = calculator.isPrime(9);
        assertFalse(testResult);
    }

    @Test(timeout = 20)
    public void isPrimeFalseTest2() {
        boolean testResult = calculator.isPrime(998);
        assertFalse(testResult);
    }

    @Test
    public void summarizeNumberRowTest() {
        int result = calculator.summarizeNumberRow(new int[]{1, 1, 1});
        assertEquals(3, result);
    }

    @Test
    public void finalMethodTest() throws Exception {
        NumberRowSupplier supplier = mock(NumberRowSupplier.class);
        when(supplier.getFinalArray()).thenReturn(new int[]{5, 5, 5});
        int testResult = calculator.summarizeNumberRow(supplier.getFinalArray());

        assertEquals(15, testResult);
    }

    @Test
    public void staticMethodTest() {
        mockStatic(NumberRowSupplier.class);
        when(NumberRowSupplier.getStaticArray()).thenReturn(new int[]{5, 5, 5});
        int testResult = calculator.summarizeNumberRow(NumberRowSupplier.getStaticArray());
        assertEquals(15, testResult);

    }

    @Test
    public void privateMethodTest() throws Exception {
        int[] array = Whitebox.invokeMethod(new NumberRowSupplier(), "getPrivateArray");
        int result = calculator.summarizeNumberRow(array);
        assertEquals(24, result);
    }

}
