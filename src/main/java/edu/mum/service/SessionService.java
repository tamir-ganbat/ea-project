package edu.mum.service;

import java.util.List;

import edu.mum.domain.Session;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface SessionService {

	@Transactional
	Integer save(Session session);

    @Transactional
	void update(Session session);

    @Transactional
	void delete(Integer id);

	Session get(Integer id);

	List<Session> find();
	
}
