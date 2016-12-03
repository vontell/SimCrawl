package com.avontell.simcrawl.domain;

/**
 * Represents a room or section in Simmons Hall
 * @author Aaron Vontell
 */

public class Room {

    private Section section;
    private int number;

    public Room(int number, Section section) {
        this.number = number;
        this.section = section;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public String toString() {
        return section.toString() + " | Room " + number;
    }

}
