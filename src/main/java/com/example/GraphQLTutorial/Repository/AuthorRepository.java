package com.example.GraphQLTutorial.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GraphQLTutorial.Models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}