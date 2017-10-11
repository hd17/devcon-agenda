package com.senacor.hd17.devcon.agenda;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;

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

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
