package com.senacor.hd17.devcon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Andri Bremm
 */

@Entity
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String speakerName;

    Speaker() {
        this.speakerName = null;
    }

    public String getSpeakerName() {
        return this.speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }
}
