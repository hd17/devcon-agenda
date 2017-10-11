package com.senacor.hd17.devcon.api;

import com.senacor.hd17.devcon.model.Agenda;
import com.senacor.hd17.devcon.services.TalksService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author Andri Bremm
 */
@RestController
public class AgendaController {

    private TalksService talksService;

    public AgendaController(TalksService talksService) {
        this.talksService = talksService;
    }

    @RequestMapping(value = "/agenda", method = RequestMethod.GET)
    public Agenda agenda(){
        Agenda agenda = new Agenda();
        agenda.setTalks(talksService.fetchTalks());
        return agenda;
    }
}
