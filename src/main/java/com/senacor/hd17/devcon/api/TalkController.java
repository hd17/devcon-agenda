package com.senacor.hd17.devcon.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.senacor.hd17.devcon.model.Talk;
import com.senacor.hd17.devcon.services.TalksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Andri Bremm
 */
@RestController
public class TalkController {

    private TalksService talksService;

    public TalkController(TalksService talksService) {
        this.talksService = talksService;
    }

    @RequestMapping(value = "/talks", method = RequestMethod.GET)
    public List<Talk> fetchTalks() {
        return talksService.fetchTalks();
    }

    @RequestMapping(value = "/talks", method = RequestMethod.PUT, produces = { "application/json" }, consumes = { "application/json" })
    public List addTalk(@RequestBody Talk json) throws JsonProcessingException {
        return talksService.addTalk(json);
    }

    @RequestMapping(value = "/talks/{id}", method = RequestMethod.GET)
    public Talk talk(@PathVariable("id") int id){
        return talksService.fetchTalk(id);
    }

    @RequestMapping(value = "/talks/init", method = RequestMethod.GET)
    public List initTalks(){
        return talksService.addMoreTalks();
    }

    @RequestMapping(value = "/talks/add/{name}/{speakerName}", method = RequestMethod.POST)
    public List addTalk(@PathVariable String name, @PathVariable String speakerName){
        return talksService.addTalk(name, speakerName, "2017-10-11T15:00:30+01:00[Europe/Paris]", "2017-10-11T16:00:00+01:00[Europe/Paris]");
    }

}
