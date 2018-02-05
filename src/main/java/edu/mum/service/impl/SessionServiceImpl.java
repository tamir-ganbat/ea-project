package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.domain.Session;
import edu.mum.repository.SessionRepo;
import edu.mum.service.SessionService;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepo sessionRepo;

    @Autowired
    public SessionServiceImpl(SessionRepo sessionRepo) {
        this.sessionRepo = sessionRepo;
    }

    public Integer save(Session session) {
        return sessionRepo.save(session);
    }

    public void update(Session session) {
        sessionRepo.save(session);
    }

    public void delete(Integer id) {
        sessionRepo.delete(get(id));
    }

    public Session get(Integer id) {
        return sessionRepo.get(id);
    }

    public List<Session> find() {
        return sessionRepo.find();
    }

}
