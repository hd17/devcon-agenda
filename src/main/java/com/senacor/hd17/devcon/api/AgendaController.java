package com.senacor.hd17.devcon.api;

import com.senacor.hd17.devcon.model.Agenda;
import com.senacor.hd17.devcon.model.Speaker;
import com.senacor.hd17.devcon.model.Talk;
import com.senacor.hd17.devcon.repositories.TalkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Collections.shuffle;
import static java.util.Collections.unmodifiableList;

/**
 * @author Andri Bremm
 */
@RestController
public class AgendaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AgendaController.class);

    private static final List<String> SPEAKER_NAMES =  unmodifiableList(
            asList("Mercy", "Largo", "Floranda", "Vlado", "Berke", "Candy", "Lemalian", "Milton", "Okko", "Leia"));
    private static final List<String> TALK_NAMES = unmodifiableList(
            asList("AWS", "Alexa", "Serverless", "Intelligente Geräte", "Java 10", "Jukito", "Spring 5", "WireMock", "Apfelschorle", "Pi"));

    private TalkRepository talkRepository;

    public AgendaController(TalkRepository talksService) {
        this.talkRepository = talksService;
    }

    @RequestMapping(value = "/agenda", method = RequestMethod.GET)
    public Agenda agenda(){
        Agenda agenda = new Agenda();
        ArrayList<Talk> talks = new ArrayList<Talk>();
        ZonedDateTime from = ZonedDateTime.now().withHour(0).withMinute(0).withSecond(0);
        ZonedDateTime to = ZonedDateTime.now().withHour(23).withMinute(59).withSecond(59);;
        for (Talk talk : talkRepository.findByStartTimeBetween(from, to)) {
            talks.add(talk);
        }
        agenda.setTalks(talks);
        return agenda;
    }

    @RequestMapping(value = "/agenda", method = RequestMethod.DELETE)
    public void deleteAgenda(){
        talkRepository.deleteAll();
    }

    @RequestMapping(value = "/agenda/generate", method = RequestMethod.POST)
    public void agenda(@RequestParam(value = "size", required = false) Integer size) {
        if (size == null || size <= 0) {
            size = 10;
        } else if (size > 10000) {
            size = 10000;
        }

        // add some randomness
        List<String> talkNames = new ArrayList<>(TALK_NAMES);
        shuffle(talkNames, new Random());
        List<String> speakerNames = new ArrayList<>(SPEAKER_NAMES);
        shuffle(speakerNames, new Random());

        List<Talk> newTalks = new ArrayList();
        for (int i = 0; i < size; i++) {
            Talk talk = new Talk();
            talk.setName(talkNames.get(i % talkNames.size()));
            Speaker speaker = new Speaker();
            speaker.setName(speakerNames.get(i % speakerNames.size()));
            talk.setSpeaker(speaker);
            ZonedDateTime myTime = generateStartTime(i);
            talk.setStartTime(myTime);
            talk.setEndTime(myTime.plusMinutes(45));
            newTalks.add(talk);
        }
        talkRepository.save(newTalks);
        LOGGER.info("{} talks saved", newTalks.size());
    }

    private static ZonedDateTime generateStartTime(int seed) {
        ZonedDateTime date = ZonedDateTime.now();
        int days = seed / 10;
        int time = seed + 1 - days;
        return date.plusDays(days).withHour((time + 8) % 23).withMinute(0).withSecond(0);
    }

}
