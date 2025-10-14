package com.example.property.repo;


import com.example.property.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {}