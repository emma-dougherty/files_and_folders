package com.codeclan.example.personfilesfolders.components;

import com.codeclan.example.personfilesfolders.models.File;
import com.codeclan.example.personfilesfolders.models.Folder;
import com.codeclan.example.personfilesfolders.models.Person;
import com.codeclan.example.personfilesfolders.repositories.FileRepository;
import com.codeclan.example.personfilesfolders.repositories.FolderRepository;
import com.codeclan.example.personfilesfolders.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    
    @Autowired
    PersonRepository personRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    FileRepository fileRepository;
    
    public DataLoader() {
    
    }
    
    public void run(ApplicationArguments args) throws Exception{
        Person person1 = new Person("Peter");
        personRepository.save(person1);
    
        Person person2 = new Person("Jane");
        personRepository.save(person2);
        
        Folder folder1 = new Folder("projects", person1);
        folderRepository.save(folder1);
    
        Folder folder2 = new Folder("films", person2);
        folderRepository.save(folder2);
    
        Folder folder3 = new Folder("music", person2);
        folderRepository.save(folder3);
        
        File file1 = new File("presentation1", "ppt", 41, folder1);
        fileRepository.save(file1);
    
        File file2 = new File("presentation2", "ppt", 60, folder1);
        fileRepository.save(file2);
    
        File file3 = new File("film1", "mov", 100, folder2);
        fileRepository.save(file3);
    
        File file4 = new File("song2", "wav", 100, folder3);
        fileRepository.save(file4);
        
        folder1.addFile(file1);
        folder1.addFile(file2);
        folderRepository.save(folder1);
        
        folder2.addFile(file3);
        folderRepository.save(folder2);
        
        person1.addFolder(folder1);
        person1.addFolder(folder2);
        personRepository.save(person1);
        
        person2.addFolder(folder2);
        personRepository.save(person2);
        
}}
