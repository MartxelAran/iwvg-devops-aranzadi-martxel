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

}