package com.t2dmtracker.webapp.repository;

import com.t2dmtracker.webapp.config.CustomProperties;
import com.t2dmtracker.webapp.model.Note;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class NoteProxy {

    private final Logger logger = LoggerFactory.getLogger(NoteProxy.class);

    private final CustomProperties customProperties;

    public NoteProxy(CustomProperties customProperties) {
        this.customProperties = customProperties;
    }

    public List<Note> getNotesByPatient(Integer id) {

        logger.debug("Calling getNotesByPatient(" + id + ")");

        String notesApiUrl = customProperties.getNotesApiUrl();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Note>> response = restTemplate.exchange(
                notesApiUrl + "/note?id=" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Note>>() {
                }
        );

        return response.getBody();
    }
}
