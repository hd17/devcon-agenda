package com.senacor.hd17.devcon.agenda;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author Andri Bremm
 */
@RestController
public class AgendaController {

    @RequestMapping(value = "/agenda", method = RequestMethod.GET)
    public Agenda agenda(){
        Agenda agenda = new Agenda();
        agenda.add(new Talk("Test 1", new Speaker("Hans"), LocalDateTime.parse("2017-10-11T15:00:30")));
        agenda.add(new Talk("AWS", new Speaker("Herbert"), LocalDateTime.parse("2017-10-12T15:05:30")));
        return agenda;
    }
}
