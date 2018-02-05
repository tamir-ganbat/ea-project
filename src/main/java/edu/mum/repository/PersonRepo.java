package edu.mum.repository;

import edu.mum.domain.Person;

import java.util.List;

/**
 * Created by 985927 on 11/20/2017
 */
public interface PersonRepo extends BaseRepo<Person, Integer>{

    public Person findByUsername(String username);

}
