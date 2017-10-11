package com.senacor.hd17.devcon.services;

import com.senacor.hd17.devcon.model.Speaker;
import com.senacor.hd17.devcon.model.Talk;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andri Bremm
 */
@Service
public class TalksService {

    public List<Talk> fetchTalks() {
        // TODO fetch from database
        List<Talk> talks = new ArrayList<>();
        talks.add(new Talk(1, "Test 1", new Speaker("Hans"), LocalDateTime.parse("2017-10-11T15:00:30")));
        talks.add(new Talk(2, "AWS", new Speaker("Herbert"), LocalDateTime.parse("2017-10-12T15:05:30")));
        return talks;
    }

    public Talk fetchTalk(int id) {
        // TODO impl.
        return fetchTalks().get(0);
    }
}
