package com.senacor.hd17.devcon.agenda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author Andri Bremm
 */
public class Talk {

    private String name;
    private Speaker speaker;
    private LocalDateTime time;

    public Talk(String name, Speaker speaker, LocalDateTime time) {
        this.name = name;
        this.speaker = speaker;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
