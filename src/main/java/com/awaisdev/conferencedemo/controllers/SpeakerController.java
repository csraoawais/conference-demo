package com.awaisdev.conferencedemo.controllers;


import com.awaisdev.conferencedemo.models.Speaker;
import com.awaisdev.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {
    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping("/getAllSpeakers")
    public List<Speaker> getAll(){
        return speakerRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Speaker get(@PathVariable Long id){
        return speakerRepository.getById(id);
    }

    @PostMapping("/create")
    public Speaker create(@RequestBody Speaker speaker){
        return  speakerRepository.saveAndFlush(speaker);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        if (id.equals(true)) {
            speakerRepository.deleteById(id);
        } else {
            System.out.println("Id not found against this object");
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker){

        Speaker existingSpeaker= speakerRepository.getById(id);
        BeanUtils.copyProperties(speaker,existingSpeaker,"speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }
}
