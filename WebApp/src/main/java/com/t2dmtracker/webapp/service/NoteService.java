package com.t2dmtracker.webapp.service;

import com.t2dmtracker.webapp.model.Note;
import com.t2dmtracker.webapp.repository.NoteProxy;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import org.slf4j.Logger;

@Service
public class NoteService {

    private final Logger logger = LoggerFactory.getLogger(NoteService.class);

    private final NoteProxy noteProxy;

    public NoteService(NoteProxy noteProxy) {
        this.noteProxy = noteProxy;
    }

    public List<Note> getNotesByPatient(Integer id) {
        logger.debug("Calling getNotesByPatient(" + id + ")");

        return noteProxy.getNotesByPatient(id);
    }
}
