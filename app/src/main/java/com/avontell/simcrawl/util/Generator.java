package com.avontell.simcrawl.util;

import com.avontell.simcrawl.domain.Section;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates objects and lists for later use
 * @author Aaron Vontell
 */

public class Generator {

    /**
     * Returns a list of sections in Simmons
     * @return the list of sections in Simmons
     */
    public static List<Section> getSections() {

        List<Section> sections = new ArrayList<>();
        sections.add(new Section("Entrance", "C", 1));
        sections.add(new Section("Common Area", "B", 1));
        sections.add(new Section("Dining", "A", 1));
        sections.add(new Section("Study Area", "C", 2));
        sections.add(new Section("Heads of House Area", "B", 2));
        sections.add(new Section("2A", "A", 2));
        sections.add(new Section("3C", "C", 3));
        sections.add(new Section("3B", "B", 3));
        sections.add(new Section("3A", "A", 3));
        sections.add(new Section("4C", "C", 4));
        sections.add(new Section("4C", "C", 1));

        return sections;

    }

}
