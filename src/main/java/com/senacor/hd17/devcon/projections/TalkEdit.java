package com.senacor.hd17.devcon.projections;

import com.senacor.hd17.devcon.model.Talk;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.time.ZonedDateTime;

/**
 * @author Simon Krauss
 */
@Projection(name = "edit", types = Talk.class)
public interface TalkEdit {

    String getName();

    @Value("#{target.speaker.toString()}")
    String getSpeaker();

    ZonedDateTime getStartTime();

    ZonedDateTime getEndTime();
}
