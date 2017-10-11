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

    public List<Talk> initTalks() {

    Talk talk1 = new Talk(talks.size(), "Test 1", new Speaker("Hans"));
        talk1.setStartTime(ZonedDateTime.parse("2017-10-11T15:00:30+01:00[Europe/Paris]"));
        talk1.setEndTime(ZonedDateTime.parse("2017-10-11T16:00:00+01:00[Europe/Paris]"));
        talks.add(talk1);

    Talk talk2 = new Talk(talks.size(), "Test 2", new Speaker("Hugo"));
        talk2.setStartTime(ZonedDateTime.parse("2017-10-11T16:00:00+01:00[Europe/Paris]"));
        talk2.setEndTime(ZonedDateTime.parse("2017-10-11T16:45:00+01:00[Europe/Paris]"));
        talks.add(talk2);

    Talk talk3 = new Talk(talks.size(), "Test 3", new Speaker("Lisa"));
        talk3.setStartTime(ZonedDateTime.parse("2017-10-11T17:00:00+01:00[Europe/Paris]"));
        talk3.setEndTime(ZonedDateTime.parse("2017-10-11T17:45:00+01:00[Europe/Paris]"));
        talks.add(talk3);

    Talk talk9 = new Talk(talks.size(), "Test 9", new Speaker("Maria"));
        talk9.setStartTime(ZonedDateTime.parse("2017-10-11T21:00:00+01:00[Europe/Paris]"));
        talk9.setEndTime(ZonedDateTime.parse("2017-10-11T21:45:00+01:00[Europe/Paris]"));
        talks.add(talk9);

    Talk talk20 = new Talk(talks.size(), "AWS", new Speaker("Herbert"));
        talk20.setStartTime(ZonedDateTime.parse("2017-10-12T15:05:30+01:00[Europe/Paris]"));
        talk20.setEndTime(ZonedDateTime.parse("2017-10-12T16:00:00+01:00[Europe/Paris]"));
        talks.add(talk20);
    // TODO fetch from database
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
