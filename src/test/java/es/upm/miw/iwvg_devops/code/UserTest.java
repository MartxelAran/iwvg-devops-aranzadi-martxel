import es.upm.miw.iwvg_devops.code.User;
import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;
    private List<Fraction> fractions;

    @BeforeEach
    void setUp() {
        fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2));
        fractions.add(new Fraction(3, 4));
        user = new User("1", "John", "Doe", fractions);
    }

    @Test
    void testDefaultConstructor() {
        User newUser = new User();
        assertNotNull(newUser.getFractions());
        assertTrue(newUser.getFractions().isEmpty());
    }

    @Test
    void testConstructor() {
        assertEquals("1", user.getId());
        assertEquals("John", user.getName());
        assertEquals("Doe", user.getFamilyName());
        assertEquals(2, user.getFractions().size());
    }

    @Test
    void testGetName() {
        assertEquals("John", user.getName());
    }

    @Test
    void testSetName() {
        user.setName("Jane");
        assertEquals("Jane", user.getName());
    }

    @Test
    void testGetFamilyName() {
        assertEquals("Doe", user.getFamilyName());
    }

    @Test
    void testSetFamilyName() {
        user.setFamilyName("Smith");
        assertEquals("Smith", user.getFamilyName());
    }

    @Test
    void testGetFractions() {
        assertEquals(2, user.getFractions().size());
    }

    @Test
    void testSetFractions() {
        List<Fraction> newFractions = new ArrayList<>();
        newFractions.add(new Fraction(5, 6));
        user.setFractions(newFractions);
        assertEquals(1, user.getFractions().size());
        assertEquals(5, user.getFractions().get(0).getNumerator());
        assertEquals(6, user.getFractions().get(0).getDenominator());
    }

    @Test
    void testAddFraction() {
        Fraction newFraction = new Fraction(7, 8);
        user.addFraction(newFraction);
        assertEquals(3, user.getFractions().size());
        assertEquals(newFraction, user.getFractions().get(2));
    }

    @Test
    void testFullName() {
        assertEquals("John Doe", user.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("J.", user.initials());
    }

    @Test
    void testToString() {
        String expectedString = "User{id='1', name='John', familyName='Doe', fractions=[Fraction{numerator=1, denominator=2}, Fraction{numerator=3, denominator=4}]}";
        assertEquals(expectedString, user.toString());
    }
}
