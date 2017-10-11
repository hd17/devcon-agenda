package com.senacor.hd17.devcon.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andri Bremm
 */
public class Agenda {

    public Agenda() {
        talks = new ArrayList<>();
    }

    private List<Talk> talks;

    public List<Talk> getTalks() {
        return talks;
    }

    public void setTalks(List<Talk> talks) {
        this.talks = talks;
    }

    public void add(Talk talk) {
        talks.add(talk);
    }

}
