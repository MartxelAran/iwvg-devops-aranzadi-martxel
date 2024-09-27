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
    void isProperTest() {
        Fraction fraction1 = new Fraction(2, 5);
        assertTrue(fraction1.isProper());
    }
    @Test
    void isImproperTest() {
        Fraction fraction1 = new Fraction(12, 5);
        assertTrue(fraction1.isImproper());
    }
    @Test
    void isEquivalentTest() {
        Fraction fraction1 = new Fraction(6, 5);
        Fraction fraction2 = new Fraction(12, 10);
        assertTrue(fraction1.isEquivalent(fraction2));
        assertTrue(fraction2.isEquivalent(fraction1));
    }
    @Test
    void addTest() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(3, 4);
        Fraction result = fraction1.add(fraction2);
        Fraction fraction = new Fraction(5, 4);
        assertTrue(fraction.isEquivalent(result));
    }
    @Test
    void multiplyTest() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(3, 4);
        Fraction result = fraction1.multiply(fraction2);
        Fraction fraction = new Fraction(3, 8);
        assertTrue(fraction.isEquivalent(result));
    }
    @Test
    void divideTest() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(3, 4);
        Fraction result = fraction2.divide(fraction1);
        assertEquals(new Fraction(6, 4).toString(), result.toString());
    }
    @Test
    void divideByZeroTest() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction zeroFraction = new Fraction(0, 1);
        assertThrows(IllegalArgumentException.class, () -> {
            fraction1.divide(zeroFraction);
        });
    }
}

