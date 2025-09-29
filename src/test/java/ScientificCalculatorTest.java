import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScientificCalculatorTest
{
    @Test
    public void testSqrt()
    {
        assertEquals(3.0,ScientificCalculator.sqrt(9),0.0001);
        assertThrows(IllegalArgumentException.class,() -> ScientificCalculator.sqrt(-1));
    }

    @Test
    public void testSqrt2()
    {
        assertEquals(4.0,ScientificCalculator.sqrt(16),0.0001);
    }

    @Test
    public void testFactorial()
    {
        assertEquals(720,ScientificCalculator.factorial(6));
        assertEquals(1,ScientificCalculator.factorial(0));
        assertThrows(IllegalArgumentException.class,() -> ScientificCalculator.factorial(-3));
    }

    @Test
    public void test_natural_log()
    {
        assertEquals(1.0,ScientificCalculator.natural_log(Math.E),0.0001);
        assertThrows(IllegalArgumentException.class,() -> ScientificCalculator.natural_log(0));
    }

    @Test
    public void testPower()
    {
        assertEquals(343.0,ScientificCalculator.power(7,3),0.0001);
        assertEquals(1.0,ScientificCalculator.power(7,0),0.0001);
    }
}