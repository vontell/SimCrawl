package com.avontell.simcrawl.domain;

/**
 * Represents a section in Simmons Hall
 * @author Aaron Vontell
 */

public class Section {

    private String title;

    public Section(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {

        return title;

    }

}
