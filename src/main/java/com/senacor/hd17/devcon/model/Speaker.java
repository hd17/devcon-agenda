package com.senacor.hd17.devcon.model;

/**
 * @author Andri Bremm
 */
public class Speaker {

    private String name;

    //standard constructor
    public Speaker(){}

    public Speaker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
