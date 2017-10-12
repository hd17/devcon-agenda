package com.senacor.hd17.devcon.frontend.formatter;

import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author Andri Bremm
 */
public class ZonedDateTimeFormatter implements Formatter<ZonedDateTime> {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy - hh:mm");

    @Override
    public String print(ZonedDateTime input, Locale locale) {
        return DATE_TIME_FORMATTER.format(input);
    }

    @Override
    public ZonedDateTime parse(String input, Locale locale) throws ParseException {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

}
