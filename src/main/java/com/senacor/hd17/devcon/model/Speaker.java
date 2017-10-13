package com.senacor.hd17.devcon.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Andri Bremm
 */

@Entity
@Table(name = "speakers")
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    public Speaker() {
        this.name = null;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
