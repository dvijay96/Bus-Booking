package com.kentravels.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kentravels.app.entity.Bus;

@Repository
public interface BusRepo extends JpaRepository<Bus, Integer> {

}
