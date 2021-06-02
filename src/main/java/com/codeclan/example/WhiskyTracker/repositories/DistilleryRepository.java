package com.codeclan.example.WhiskyTracker.repositories;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistilleryRepository  extends JpaRepository<Distillery, Long> {
}
