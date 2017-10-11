package com.senacor.hd17.devcon.api;

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
    public List<Talk> talk() {
        return talksService.fetchTalks();
    }

    @RequestMapping(value = "/talks/{id}", method = RequestMethod.GET)
    public Talk talk(@PathVariable("id") int id){
        return talksService.fetchTalk(id);
    }
}
