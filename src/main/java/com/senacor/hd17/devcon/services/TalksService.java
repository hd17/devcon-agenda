package com.senacor.hd17.devcon.services;

import com.senacor.hd17.devcon.model.Speaker;
import com.senacor.hd17.devcon.model.Talk;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andri Bremm
 */
@Service
public class TalksService {

    private List<Talk> talks = new ArrayList<>();

    public TalksService() {
        Talk talk1 = new Talk(talks.size(), "Alexa", new Speaker("Maria"));
        talk1.setStartTime(ZonedDateTime.parse("2017-10-11T21:00:00+01:00[Europe/Paris]"));
        talk1.setEndTime(ZonedDateTime.parse("2017-10-11T21:45:00+01:00[Europe/Paris]"));
        talks.add(talk1);

        Talk talk2 = new Talk(talks.size(), "AWS", new Speaker("Herbert"));
        talk2.setStartTime(ZonedDateTime.parse("2017-10-12T15:05:30+01:00[Europe/Paris]"));
        talk2.setEndTime(ZonedDateTime.parse("2017-10-12T16:00:00+01:00[Europe/Paris]"));
        talks.add(talk2);
    }

    public List<Talk> addMoreTalks() {
        int talkNr = talks.size();
        Talk talk1 = new Talk(talkNr, "Test " + talkNr, new Speaker("Hans"));
        talk1.setStartTime(ZonedDateTime.parse("2017-10-12T15:00:30+01:00[Europe/Paris]"));
        talk1.setEndTime(ZonedDateTime.parse("2017-10-12T16:00:00+01:00[Europe/Paris]"));
        talks.add(talk1);

        talkNr = talks.size();
        Talk talk2 = new Talk(talkNr, "Test " + talkNr, new Speaker("Hugo"));
        talk2.setStartTime(ZonedDateTime.parse("2017-10-12T16:00:00+01:00[Europe/Paris]"));
        talk2.setEndTime(ZonedDateTime.parse("2017-10-12T16:45:00+01:00[Europe/Paris]"));
        talks.add(talk2);

        talkNr = talks.size();
        Talk talk3 = new Talk(talkNr, "Test " + talkNr, new Speaker("Lisa"));
        talk3.setStartTime(ZonedDateTime.parse("2017-10-12T17:00:00+01:00[Europe/Paris]"));
        talk3.setEndTime(ZonedDateTime.parse("2017-10-12T17:45:00+01:00[Europe/Paris]"));
        talks.add(talk3);

        talkNr = talks.size();
        Talk talk4 = new Talk(talkNr, "Test " + talkNr, new Speaker("Maria"));
        talk4.setStartTime(ZonedDateTime.parse("2017-10-11T18:00:00+01:00[Europe/Paris]"));
        talk4.setEndTime(ZonedDateTime.parse("2017-10-11T18:45:00+01:00[Europe/Paris]"));
        talks.add(talk4);
        return talks;
    }

    public List<Talk> fetchTalks() {
        // TODO fetch from database
        return talks;
    }

    public Talk fetchTalk(int id) {
        // TODO impl.
        return fetchTalks().get(id);
    }

    public List<Talk> addTalk(String name, String speakerName, String startTime, String EndTime) {
        Talk newTalk = new Talk(talks.size(), name, new Speaker(speakerName));
        newTalk.setStartTime(ZonedDateTime.parse(startTime));
        newTalk.setEndTime(ZonedDateTime.parse(EndTime));
        talks.add(newTalk);
        return talks;
    }

    public List<Talk> addTalk(Talk talk) {
        talk.setId(talks.size());
        talks.add(talk);
        return talks;
    }
}
