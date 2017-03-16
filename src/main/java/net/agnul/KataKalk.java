package net.agnul;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

@Slf4j
public class KataKalk {

    private static final String DEFAULT_DELIMITERS = ",\n";

    public int add(String s) {
        String[] strings = StringUtils.split(s, getDelimiters(s));
        log.info("STRINGS {}, size {}", strings, strings.length);

        List<Integer> numbers = Arrays.stream(strings)
                .map(this::trimSpaces)
                .map(this::convertToInteger)
                .filter(n -> n <= 1000)
                .collect(Collectors.toList());

        List<Integer> negatives = numbers.stream()
                .filter(n -> n < 0)
                .collect(Collectors.toList());

        if ( ! negatives.isEmpty() ) {
            throw new IllegalArgumentException(String.format(
                    "Negative numbers are not allowed %s", StringUtils.join(negatives, ",")));
        }

        return numbers.stream().reduce(this::addNumbers).orElse(0);

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

    private int addNumbers(int runningTotal, int n) {

        return runningTotal + n;

    }

}
