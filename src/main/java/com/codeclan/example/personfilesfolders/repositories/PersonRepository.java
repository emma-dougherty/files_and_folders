package com.codeclan.example.personfilesfolders.repositories;
import com.codeclan.example.personfilesfolders.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository <Person, Long>{
}
