package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.Session;

import java.util.List;

public interface SessionCustomJpaRepository {
    List<Session> customGetSessions();
}
