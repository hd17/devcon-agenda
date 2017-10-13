package com.senacor.hd17.devcon.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * @author Andri Bremm
 */
@Entity
@Table(name = "talks")
public class Talk implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Speaker speaker;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Speaker> coSpeakers;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;

    public Talk() {
        this.name = null;
        this.speaker = null;
        this.coSpeakers = null;
        this.startTime = null;
        this.endTime = null;
    }

    public long getId() {
        return id;
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

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public List<Speaker> getCoSpeakers() {return coSpeakers;}

    public void setCoSpeaker(Speaker speaker) {
        this.coSpeakers.add(speaker);
    }
}
