package com.awaisdev.conferencedemo.controllers;

import com.awaisdev.conferencedemo.models.Session;
import com.awaisdev.conferencedemo.repositories.SessionRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/sessions")
public class SessionController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping("/all")
    public List<Session> getAll (){
        return sessionRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Session getById(@PathVariable Long id)
    {
        return sessionRepository.getById(id);
    }
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public  Session create(@RequestBody Session session){
        return sessionRepository.saveAndFlush(session);
    }

    @DeleteMapping("/delete/{id}")
    //@RequestMapping(value = "{id}")
    public void delete(@PathVariable Long id) {
        if (id.equals(true)) {
            sessionRepository.deleteById(id);
        } else {
            System.out.println("Id not found against this object");
        }
    }

        @RequestMapping(method = RequestMethod.PUT ,value = "/update/{id}")
        public Session update(@PathVariable Long id, @RequestBody Session session){

        Session existingSession= sessionRepository.getById(id);
            BeanUtils.copyProperties(session,existingSession,"session_id");
            return sessionRepository.saveAndFlush(existingSession);
        }



    }


