package com.awaisdev.conferencedemo.repositories;

import com.awaisdev.conferencedemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {
//    @Query(value="select * from sessions s", nativeQuery=true)
//    public List<Session> getAllSessions();

}
