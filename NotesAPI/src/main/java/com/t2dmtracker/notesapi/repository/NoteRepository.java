package com.t2dmtracker.notesapi.repository;

import com.t2dmtracker.notesapi.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
}
