package com.t2dmtracker.notesapi.controller;

import com.t2dmtracker.notesapi.model.Note;
import com.t2dmtracker.notesapi.service.INoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteController {
    private final INoteService noteService;

    public NoteController(INoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/note")
    public List<Note> getNotesByPatient(@RequestParam Integer id) {
        return noteService.getNotesByPatient(id);
    }
}
