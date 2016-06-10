package com.thoughtworks.conference.presenter;

import com.thoughtworks.conference.viewmodel.Event;

import java.util.List;

/**
 * Created by sreedhj on 6/10/16.
 */
public interface TrackView {
    void render(List<Event> sessionViewModels);
}
