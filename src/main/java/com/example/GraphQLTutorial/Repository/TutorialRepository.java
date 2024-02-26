package com.example.GraphQLTutorial.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GraphQLTutorial.Models.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}

