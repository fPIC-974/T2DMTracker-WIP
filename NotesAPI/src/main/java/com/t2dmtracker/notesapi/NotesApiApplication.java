package com.t2dmtracker.notesapi;

import com.t2dmtracker.notesapi.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotesApiApplication implements CommandLineRunner {

	@Autowired
	private NoteService noteService;

	public static void main(String[] args) {
		SpringApplication.run(NotesApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
