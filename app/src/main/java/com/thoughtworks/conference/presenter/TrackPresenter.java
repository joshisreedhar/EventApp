package com.thoughtworks.conference.presenter;

import com.thoughtworks.conference.model.Session;
import com.thoughtworks.conference.viewmodel.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sreedhj on 6/10/16.
 */
public class TrackPresenter {
    List<Session> sessions;
    private TrackView view;

    public TrackPresenter(List<Session> sessions, TrackView view) {
       this.sessions  = sessions;
        this.view = view;
    }

    public void presentSessions() {
        List<Event> sessionViewModels = new ArrayList<>();
        for (Session session : sessions) {

            sessionViewModels.add(new Event(session));
        }

        view.render(sessionViewModels);
    }
}
