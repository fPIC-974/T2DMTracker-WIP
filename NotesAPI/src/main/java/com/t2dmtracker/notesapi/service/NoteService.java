package com.t2dmtracker.notesapi.service;

import com.t2dmtracker.notesapi.model.Note;
import com.t2dmtracker.notesapi.repository.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements INoteService {
    private final Logger logger = LoggerFactory.getLogger(NoteService.class);

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> getNotesByPatient(String id) {
        logger.debug("Calling getNotesByPatient(" + id + ")");

        List<Note> notes = noteRepository.findByPatientId(id);

        logger.debug(notes.toString());

        return notes;
    }
}
