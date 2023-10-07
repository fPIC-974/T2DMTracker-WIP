package com.t2dmtracker.notesapi.service;

import com.t2dmtracker.notesapi.model.Note;

import java.util.List;

public interface INoteService {
    List<Note> getNotesByPatient(String id);

    Note addNote(Note note);
}
