package com.thoughtworks.conference.util;

import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.util.Date;

public class TestDataUtil {

    public static Date parseDate(String dateTimeAsString) {
        DateTimeFormatter parser = ISODateTimeFormat.dateTimeNoMillis();
        return parser.parseDateTime(dateTimeAsString).toDate();
    }
}
