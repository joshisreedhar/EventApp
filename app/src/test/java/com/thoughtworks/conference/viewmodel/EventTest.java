package com.thoughtworks.conference.viewmodel;

import com.thoughtworks.conference.model.Category;
import com.thoughtworks.conference.model.Session;
import com.thoughtworks.conference.util.TestDataUtil;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertEquals;

public class EventTest {

    @Test
    public void aEventShouldHaveDurationFormattedForMinutes() {
        Session session = getSession("2016-06-09T10:30:00+05:30", "2016-06-09T11:00:00+05:30");
        Event displayEvent = new Event(session);

        String duration = displayEvent.getDuration();

        assertEquals("10:30 AM - 11:00 AM (30m)",duration);
    }

    @Test
    public void aEventShouldHaveDurationFormattedForHours() {
        Session session = getSession("2016-06-09T10:30:00+05:30", "2016-06-09T12:30:00+05:30");
        Event displayEvent = new Event(session);

        String duration = displayEvent.getDuration();

        assertEquals("10:30 AM - 12:30 PM (2h)",duration);
    }

    @Test
    public void aEventShouldHaveDurationFormattedForHoursAndMinutes() {
        Session session = getSession("2016-06-09T10:30:00+05:30", "2016-06-09T12:00:00+05:30");
        Event displayEvent = new Event(session);

        String duration = displayEvent.getDuration();

        assertEquals("10:30 AM - 12:00 PM (1h30m)",duration);

    }

    @Test
    public void aEventShouldHaveAName(){
        Session session = getSession();
        Event event = new Event(session);

        assertEquals("TestSession1", event.getName());
    }

    @Test
    public void aEventShouldHaveALocation(){
        Session session = getSession();
        Event event = new Event(session);

        assertEquals("room1", event.getLocation());
    }

    private Session getSession(String fromTime, String toTime) {
        TestDataUtil util = new TestDataUtil();
        Date from = util.parseDate(fromTime);
        Date to = util.parseDate(toTime);
        return new Session("TestSession1", "TestSession1", from,to , Category.ASPIRE, "room1");
    }

    private Session getSession(){
        return getSession("2016-06-09T10:30:00+05:30", "2016-06-09T12:30:00+05:30");
    }

}
