package com.avontell.simcrawl.domain;

/**
 * Represents a section in Simmons Hall
 * @author Aaron Vontell
 */

public class Section {

    private String title;
    private String tower;
    private int floor;

    public Section(String title, String tower, int floor) {
        this.title = title;
        this.tower = tower;
        this.floor = floor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTower() {
        return tower;
    }

    public void setTower(String tower) {
        this.tower = tower;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
