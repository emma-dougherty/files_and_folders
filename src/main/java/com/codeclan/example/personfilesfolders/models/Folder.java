package com.codeclan.example.personfilesfolders.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "folders")

public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "title")
    private String title;
    
    @JsonIgnoreProperties({"folder"})
    @OneToMany(mappedBy = "folder")
    private List<File> files;
    
    @ManyToOne
    @JoinColumn(name = "person")
    @JsonIgnoreProperties({"folders"})
    private Person person;
    
    public Folder(String title, Person person) {
        this.title = title;
        this.person = person;
        this.files = new ArrayList<File>();
    }
    
    public Folder() {
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public List<File> getFiles() {
        return files;
    }
    
    public void setFiles(List<File> files) {
        this.files = files;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void addFile(File file){
        this.files.add(file);
    }
}
