package com.hibernate.sql;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NoteController {

	@Autowired
	NoteRepositoryWithPage noteRepositorywithPage;

	@GetMapping("/getallpage")
	public Page<Note> getAllNotesPage() {
		Pageable pageable = PageRequest.of(0, 100);
		Page<Note> page = noteRepositorywithPage.findAll(pageable);

		return page;
	}

	@GetMapping("/gettitlepage/{title}")
	public Page<Note> getNotesTitlePage(@PathVariable(value = "title") String title) {
		Pageable pageable = PageRequest.of(0, 1);
		Page<Note> page = noteRepositorywithPage.findByTitle(title,pageable);

		return page;
	}

	@Autowired
	NoteRepository noteRepository1;

	@Autowired
	NoteRepositoryCrudRepository noteRepository;

	@GetMapping("/test")
	public String test() {

		return "Success";
	}

	/*
	 * // Get All Notes
	 * 
	 * @GetMapping("/notes/getall") public List<Note> getAllNotes() { return
	 * noteRepository.findAll(); }
	 */

	// Get All Notes
	@GetMapping("/notes/getall")
	public Iterable<Note> getAllNotesCurd() {
		return noteRepository.findAll();
	}

	// Create a new Note
	@PostMapping("/notes/add")
	public Note createNote(@Valid @RequestBody Note note) {
		return noteRepository.save(note);
	}

	// Get a Single Note
	@GetMapping("/notes/{id}")
	public Note getNoteById(@PathVariable(value = "id") Long noteId) {
		return noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
	}
	// Update a Note

	@PutMapping("/notes/{id}")
	public Note updateNote(@PathVariable(value = "id") Long noteId, @Valid @RequestBody Note noteDetails) {

		Note note = noteRepository.findById(noteId)
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

		note.setTitle(noteDetails.getTitle());
		note.setContent(noteDetails.getContent());

		Note updatedNote = noteRepository.save(note);
		return updatedNote;
	}
	// Delete a Note

	@DeleteMapping("/notes/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
		Note note = noteRepository.findById(noteId)
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

		noteRepository.delete(note);

		return ResponseEntity.ok().build();
	}
}