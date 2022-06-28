package com.codeclan.example.personfilesfolders.repositories;
import com.codeclan.example.personfilesfolders.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository  extends JpaRepository<File, Long> {
}
