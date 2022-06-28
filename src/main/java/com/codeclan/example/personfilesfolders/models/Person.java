package com.codeclan.example.personfilesfolders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persons")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name = "persons")
    private String name;
    
    
    @JsonIgnoreProperties({"persons"})
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "folders",
            joinColumns = {@JoinColumn(name = "person_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "folder_id", nullable = false, updatable = false)}
    )
    private List<Folder> folders;
    
    public Person(String name) {
        this.name = name;
        this.folders = new ArrayList<Folder>();
    }
    
    public Person() {
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public List<Folder> getFolders() {
        return folders;
    }
    
    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }
    
    public void addFolder(Folder folder){
        this.folders.add(folder);
    }
}
