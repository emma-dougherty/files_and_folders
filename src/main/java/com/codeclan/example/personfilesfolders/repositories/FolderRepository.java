package com.codeclan.example.personfilesfolders.repositories;
import com.codeclan.example.personfilesfolders.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository  extends JpaRepository<Folder, Long> {
}
