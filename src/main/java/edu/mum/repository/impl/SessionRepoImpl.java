package edu.mum.repository.impl;

import edu.mum.domain.Session;
import edu.mum.repository.BaseHibernateDaoSupport;
import edu.mum.repository.SessionRepo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Erdenebayar on 11/20/2017
 */
@Repository
public class SessionRepoImpl extends BaseHibernateDaoSupport<Session, Integer> implements SessionRepo {

    public SessionRepoImpl() {
        super(Session.class);
    }
}
