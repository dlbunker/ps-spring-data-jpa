package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {

    public List<Session> findBySessionNameContaining(String name);
}
