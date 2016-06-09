package com.thoughtworks.conference.model;

import java.util.ArrayList;
import java.util.List;

public class Conference {
  private List<Session> sessions;

  public Conference(){
  }

  public Conference(List<Session> sessions){
    this.sessions = sessions;
  }

  public List<Session> getSessionsFor(Category category) {
    List<Session> filteredSessions = new ArrayList<>();
    for(Session session: sessions) {
      if(session.getCategory() == category) {
        filteredSessions.add(session);
      }
    }
    return filteredSessions;
  }
}