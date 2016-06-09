package com.thoughtworks.conference;

import com.thoughtworks.conference.model.Category;
import com.thoughtworks.conference.model.Conference;
import com.thoughtworks.conference.model.Session;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class ConferenceTest {

    List<Session> sessions;

    @Before
    public void setup() {
        sessions = new ArrayList<>();
        sessions.add(new Session("TestSession1", "TestSession1", new Date(), new Date(), Category.ASPIRE, "room1"));
        sessions.add(new Session("TestSession2", "TestSession2", new Date(), new Date(), Category.BELONG, "room2"));
        sessions.add(new Session("TestSession3", "TestSession3", new Date(), new Date(), Category.CREATE, "room3"));
        sessions.add(new Session("TestSession4", "TestSession4", new Date(), new Date(), Category.ASPIRE, "room4"));
    }

    @Test
    public void aConferenceShouldGiveASetOfCategorisedSessions() {
        Conference conference = new Conference(sessions);

        List<Session> aspireSessions = conference.getSessionsFor(Category.ASPIRE);
        List<Session> expectedSessions = new ArrayList<>();

        expectedSessions.add(new Session("TestSession1", "TestSession1", new Date(), new Date(), Category.ASPIRE, "room1"));
        expectedSessions.add(new Session("TestSession4", "TestSession4", new Date(), new Date(), Category.ASPIRE, "room4"));

        assertEquals(2, aspireSessions.size());

        for (Session session : aspireSessions) {
            assertEquals(session.getCategory(), Category.ASPIRE);
        }

    }
}
