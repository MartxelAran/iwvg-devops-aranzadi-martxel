package es.upm.miw.iwvg_devops.code;

import org.apache.logging.log4j.LogManager;

import java.util.Objects;
import java.util.stream.Stream;

public class Searches {

    public Stream<Double> findDecimalImproperFractionByUserName(String name) {
        UsersDatabase db = new UsersDatabase();
        return db.findAll()
                .filter(user -> user.getName().equals(name))
                .flatMap(user -> user.getFractions().stream())
                .filter(fraction -> fraction.isImproper())
                .map(Fraction::decimal);
    }

    public Stream<String> findUserFamilyNameByAllNegativeSignFractionDistinct() {
        UsersDatabase db = new UsersDatabase();
        return db.findAll()
                .filter(user -> user.getFractions().stream()
                        .allMatch(fraction -> fraction.getNumerator() < 0 && fraction.getDenominator() < 0))
                .map(User::getFamilyName)
                .distinct();
    }

    public Stream<String> findUserIdBySomeProperFraction() {
        UsersDatabase db = new UsersDatabase();
        return db.findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fraction.isProper()))
                .map(User::getId)
                .distinct();
    }

    public Fraction findFirstProperFractionByUserId(String userId) {
        UsersDatabase db = new UsersDatabase();
        return db.findAll()
                .filter(user -> user.getId().equals(userId))
                .flatMap(user -> user.getFractions().stream())
                .filter(fraction -> fraction.getNumerator() < fraction.getDenominator())
                .findFirst()
                .orElse(null);

    }

}