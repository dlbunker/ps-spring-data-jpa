package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    @Autowired
    private SessionRepository repository;

    @GetMapping
    public List<Session> list(@RequestParam(required = false) String name) {
        if(name != null) {
            return repository.findBySessionNameContaining(name);
        } else {
            return repository.findAll();
        }
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        return repository.getOne(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session){
        return repository.saveAndFlush(session);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        //because this is a PUT, we expect all attributes to be passed in. A PATCH would only need what has changed.
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Session existingSession = repository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return repository.saveAndFlush(session);
    }

}
