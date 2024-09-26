package es.upm.miw.iwvg_devops.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    private Fraction fraction;

    @BeforeEach
    void setUp() {
        fraction = new Fraction(3, 4);
    }

    @Test
    void testDefaultConstructor() {
        Fraction defaultFraction = new Fraction();
        assertEquals(1, defaultFraction.getNumerator());
        assertEquals(1, defaultFraction.getDenominator());
    }

    @Test
    void testConstructor() {
        assertEquals(3, fraction.getNumerator());
        assertEquals(4, fraction.getDenominator());
    }

    @Test
    void testGetNumerator() {
        assertEquals(3, fraction.getNumerator());
    }

    @Test
    void testSetNumerator() {
        fraction.setNumerator(5);
        assertEquals(5, fraction.getNumerator());
    }

    @Test
    void testGetDenominator() {
        assertEquals(4, fraction.getDenominator());
    }

    @Test
    void testSetDenominator() {
        fraction.setDenominator(6);
        assertEquals(6, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        assertEquals(0.75, fraction.decimal());
    }

    @Test
    void testToString() {
        assertEquals("Fraction{numerator=3, denominator=4}", fraction.toString());
    }

    @Test
    void testDivisionByZeroDenominator() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            Fraction invalidFraction = new Fraction(1, 0);
            invalidFraction.decimal();
        });
        assertTrue(exception.getMessage().contains("/ by zero"));
    }
}

