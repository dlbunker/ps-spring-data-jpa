package com.pluralsight.conferencedemo.models;

import com.pluralsight.conferencedemo.repositories.SpeakerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SpeakerTest {
    @Autowired
    private SpeakerJpaRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testFind() throws Exception {
        Speaker speaker = repository.getOne(1L);
        assertNotNull(speaker);
    }

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
        Speaker s = new Speaker();
        s.setCompany("Pluralsight");
        s.setFirstName("Dan");
        s.setLastName("Bunker");
        s.setTitle("Author");
        s.setSpeakerBio("Consulting and mentoring");
        s = repository.saveAndFlush(s);

        // clear the persistence context so we don't return the previously cached location object
        // this is a test only thing and normally doesn't need to be done in prod code
        entityManager.clear();

        Speaker otherSpeaker = repository.getOne(s.getSpeakerId());
        assertEquals("Dan", otherSpeaker.getFirstName());

        repository.deleteById(otherSpeaker.getSpeakerId());
    }

    @Test
    public void testJpaAnd() throws Exception {
        List<Speaker> speakers = repository.findByFirstNameAndLastName("Justin", "Clark");
        assertTrue(speakers.size() > 0);
    }

    @Test
    public void testJpaOr() throws Exception {
        List<Speaker> speakers = repository.findByFirstNameOrLastName("Justin", "Clark");
        assertTrue(speakers.size() > 0);
    }

    @Test
    public void testJpaNull() throws Exception {
        List<Speaker> speakers = repository.findBySpeakerPhotoNull();
        assertTrue(speakers.size() > 0);
    }

    @Test
    public void testJpaIn() throws Exception {
        List<String> companies = new ArrayList<>();
        companies.add("National Bank");
        companies.add("Contoso");
        List<Speaker> speakers = repository.findByCompanyIn(companies);
        assertTrue(speakers.size() > 0);
    }

    @Test
    public void testJpaIgnoreCase() throws Exception {
        List<Speaker> speakers = repository.findByCompanyIgnoreCase("national bank");
        assertTrue(speakers.size() > 0);
    }

    @Test
    public void testJpaOrderBy() throws Exception {
        List<Speaker> speakers = repository.findByLastNameOrderByFirstNameAsc("Clark");
        assertTrue(speakers.size() > 0);
    }

    @Test
    public void testJpaFirst() throws Exception {
        Speaker speaker = repository.findFirstByFirstName("James");
        assertTrue(speaker.getFirstName().equals("James"));
    }
}
