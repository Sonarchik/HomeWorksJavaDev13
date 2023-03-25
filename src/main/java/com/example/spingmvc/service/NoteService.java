package com.example.spingmvc.service;

import com.example.spingmvc.entity.Note;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    private final Map<Long, Note> notes = new HashMap<>();
    private final Random random = new Random();

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note) {
        long id = random.nextLong();
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    public void deleteById(long id) {
        try {
            notes.remove(id);
        } catch (Exception ex) {
            System.err.println("It is not possible to delete a note with this ID");
        }
    }

    public void update(Note note) {
        try {
            long id = note.getId();
            notes.put(id, note);
        } catch (Exception e) {
            System.err.println("It is not possible to update a note with this ID");
        }
    }

    public Note getById(long id) {
        try {
            return notes.get(id);
        } catch (Exception e) {
            System.err.println("No such note exists");
        }
        return null;
    }
}
