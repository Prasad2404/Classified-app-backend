package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.Advertisement;



public interface ImageRepository extends JpaRepository<Advertisement, Long> {

}


