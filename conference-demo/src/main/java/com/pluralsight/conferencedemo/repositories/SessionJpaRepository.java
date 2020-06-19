package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionJpaRepository extends JpaRepository<Session, Long>, SessionCustomJpaRepository {
    List<Session> findBySessionNameContains(String name);
    List<Session> findBySessionNameNotLike(String name);
    List<Session> findBySessionLengthNot(Integer sessionLength);
    List<Session> findBySessionLengthLessThan(Integer sessionLength);

    @Query("select s from Session s where s.sessionName like %:name")
    Page<Session> getSessionsWithName(@Param("name") String name, Pageable pageable);
}
