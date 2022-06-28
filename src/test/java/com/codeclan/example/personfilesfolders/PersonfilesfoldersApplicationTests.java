package com.codeclan.example.personfilesfolders;

import com.codeclan.example.personfilesfolders.models.File;
import com.codeclan.example.personfilesfolders.models.Folder;
import com.codeclan.example.personfilesfolders.models.Person;
import com.codeclan.example.personfilesfolders.repositories.FileRepository;
import com.codeclan.example.personfilesfolders.repositories.FolderRepository;
import com.codeclan.example.personfilesfolders.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonfilesfoldersApplicationTests {
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	FolderRepository folderRepository;
	
	@Autowired
	FileRepository fileRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void createPersonAndFileThenSave(){
		Person person1 = new Person("Peter");
		personRepository.save(person1);
		Folder folder1 = new Folder("projects", person1);
		folderRepository.save(folder1);
		File file1 = new File("presentation1", "ppt", 41, folder1);
		fileRepository.save(file1);
	}
	
	@Test
	public void createFileAndFolderThenSave(){
		Person person2 = new Person("Jane");
		personRepository.save(person2);
		
		Folder folder2 = new Folder("films", person2);
		folderRepository.save(folder2);
		
		File file2 = new File("presentation2", "ppt", 60, folder2);
		fileRepository.save(file2);
		
		person2.addFolder(folder2);
		folder2.addFile(file2);
		folderRepository.save(folder2);
	}

}
