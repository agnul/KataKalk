package net.agnul;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

@Slf4j
public class KataKalk {

    private static final String DEFAULT_DELIMITERS = ",\n";

    public int add(String s) {
        String[] strings = StringUtils.split(s, getDelimiters(s));
        log.info("STRINGS {}, size {}", strings, strings.length);

        return Arrays.stream(strings)
                .map(this::trimSpaces)
                .map(this::convertToInteger)
                .map(this::throwOnNegatives)
                .reduce(this::addNumbers)
                .orElse(0);

    }

    private String getDelimiters(String s) {

        return DEFAULT_DELIMITERS + StringUtils.substringBetween(s, "//", "\n");

    }

    private String trimSpaces(String s) {

        return StringUtils.trim(s);

    }

    private int convertToInteger(String s) {

        return NumberUtils.toInt(s);

    }

    private int throwOnNegatives(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed: " + n);
        }

        return n;

    }

    private int addNumbers(int runningTotal, int n) {

        return runningTotal + n;

    }

}
