package com.codeclan.example.personfilesfolders.controller;

import com.codeclan.example.personfilesfolders.models.Person;
import com.codeclan.example.personfilesfolders.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    public class PersonController {
        @Autowired
        PersonRepository personRepository;
        
        
        @GetMapping(value = "/persons")
        public ResponseEntity<List<Person>> getAllPersons(){
            return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
        }
        
        @GetMapping(value = "/persons/{id}")
        public ResponseEntity getPerson(@PathVariable Long id){
            return new ResponseEntity<>(personRepository.findById(id), HttpStatus.OK);
        }
        
        @PostMapping(value = "/persons")
        public ResponseEntity<Person> postPerson(@RequestBody Person person){
            personRepository.save(person);
            return new ResponseEntity<>(person, HttpStatus.CREATED);
        }
        
    }
