package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchesTest {
    @Test
    void testFindDecimalImproperFractionByUserName() {
        // Name Ana
        assertEquals(List.of(2.0, 4.0 / 3.0),
                new Searches().findDecimalImproperFractionByUserName("Ana")
                        .collect(Collectors.toList()));
    }

    @Test
    void testFindUserFamilyNameByAllNegativeSignFractionDistinct() {
        assertEquals(List.of("Aranzadi"),
                new Searches().findUserFamilyNameByAllNegativeSignFractionDistinct()
                        .collect(Collectors.toList()));
    }

    @Test
    void testFindUserIdBySomeProperFraction() {
        assertEquals(List.of("1", "2", "3", "5", "7"),
                new Searches().findUserIdBySomeProperFraction()
                        .collect(Collectors.toList()));
    }

    @Test
    void testFindFirstProperFractionByUserId_ExistingUser() {
        Fraction fraction = new Searches().findFirstProperFractionByUserId("2");
        assertEquals(new Fraction(-1, 5), fraction);

    }
}