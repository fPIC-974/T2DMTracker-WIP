package com.t2dmtracker.notesapi;

import com.t2dmtracker.notesapi.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// TODO - Disabling Spring Security for testing purposes
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class NotesApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NotesApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
