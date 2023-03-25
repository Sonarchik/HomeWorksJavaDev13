package com.example.spingmvc.endpoint;

import com.example.spingmvc.entity.Note;
import com.example.spingmvc.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView result = new ModelAndView("note");
        result.addObject("noteList", noteService.listAll() );
        return result;
    }

    @PostMapping("/delete")
    public RedirectView delete(long id) {
        noteService.deleteById(id);
        return new RedirectView("/note/list");
    }
    @GetMapping("/edit")
    public ModelAndView edit(long id){
        ModelAndView result = new ModelAndView("addAndEdit");
        result.addObject("note", noteService.getById(id));
        return result;
    }

    @PostMapping("/edit")
    public RedirectView edit(long id, String title, String content) {
        Note note = new Note();
        note.setId(id);
        note.setTitle(title);
        note.setContent(content);
        noteService.update(note);
        return new RedirectView("/note/list");
    }
    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView result = new ModelAndView("addAndEdit");
        result.addObject("note", null);
        return result;
    }

    @PostMapping("/add")
    public RedirectView add( String title, String content){
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        noteService.add(note);
        return new RedirectView("/note/list");
    }
}
