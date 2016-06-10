package com.thoughtworks.conference.presenter;

import com.thoughtworks.conference.model.Category;
import com.thoughtworks.conference.model.Session;
import com.thoughtworks.conference.util.TestDataUtil;
import com.thoughtworks.conference.viewmodel.Event;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TrackPresenterTest {

    List<Session> sessions;
    @Before
    public void setup() {
        sessions = new ArrayList<>();
        sessions.add(getSession());
    }
    @Test
    public void aViewIsInformedWhenViewModelsIsReady() {
        TrackView view = mock(TrackView.class);
        TrackPresenter presenter = new TrackPresenter(sessions, view);
        presenter.presentSessions();
        List<Event> sessionViewModels = new ArrayList<Event>();
        sessionViewModels.add(new Event(sessions.get(0)));
        Mockito.verify(view).render(Mockito.eq(sessionViewModels));
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
