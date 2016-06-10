package com.thoughtworks.conference.viewmodel;

import com.thoughtworks.conference.model.Session;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Event {

    private Session session;

    public Event(Session session) {
        this.session = session;
    }

    public String getDuration() {
        return representTimeDurationAsString() + representPeriodAsString();
    }

    private String representTimeDurationAsString() {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        return dateFormat.format(session.getStartTime()) + " - " + dateFormat.format(session.getEndTime());
    }

    private String representPeriodAsString(){
        final int MILLI_TO_MINUTE = 1000 * 60 ;
        int peridInMinutes =  (int) (session.getEndTime().getTime() - session.getStartTime().getTime()) / MILLI_TO_MINUTE;
        int hours = (int) peridInMinutes/60;
        int minutes = (int) peridInMinutes%60;
        String durationInhours = hours == 0 ? "" : String.valueOf(hours) + "h";
        String durationInminutes = minutes == 0 ? "" : String.valueOf(minutes) + "m";
        return String.format(" (%s%s)",durationInhours,durationInminutes);

    }

    public String getName() {
        return session.getName();
    }

    public String getLocation() {
        return session.getLocation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        return !(session != null ? !session.equals(event.session) : event.session != null);

    }

    @Override
    public int hashCode() {
        return session != null ? session.hashCode() : 0;
    }
}
