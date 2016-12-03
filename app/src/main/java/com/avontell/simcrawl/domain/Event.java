package com.avontell.simcrawl.domain;

import java.util.Date;

/**
 * Represents an Event in Simmons Hall
 * @author Aaron Vontell
 */

public class Event {

    private EventType type;
    private Room room;
    private Date timeStart;
    private Date timeEnd;
    private int count;
    private String title;
    private boolean dormEvent;

    public Event(String title, EventType type, Room room, boolean dormEvent, Date timeStart, Date timeEnd, int count) {
        this.title = title;
        this.type = type;
        this.room = room;
        this.dormEvent = dormEvent;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isDormEvent() {
        return dormEvent;
    }

    public void setDormEvent(boolean dormEvent) {
        this.dormEvent = dormEvent;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
