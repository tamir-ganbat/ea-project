package edu.mum.repository.impl;

import edu.mum.domain.Person;
import edu.mum.domain.Session;
import edu.mum.repository.BaseHibernateDaoSupport;
import edu.mum.repository.PersonRepo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 985927 on 11/20/2017
 */
@Repository
public class PersonRepoImpl extends BaseHibernateDaoSupport<Person, Integer> implements PersonRepo {

    public PersonRepoImpl() {
        super(Person.class);
    }

    @Override
    public Person findByUsername(String username) {
        if (username == null) return null;

        return (Person) getSession().createQuery("FROM Person p where p.username =:username")
                .setParameter("username", username).uniqueResult();
    }
}
