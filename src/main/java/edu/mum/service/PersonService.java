package edu.mum.service;

import edu.mum.domain.Person;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 985927 on 11/20/2017
 */
@Transactional(readOnly = true)
public interface PersonService {

    @Transactional
    public void save(Person person);

    @Transactional
    void update(Person person);

    public List<Person> find();

    public Person get(Integer id);

    public Person findByUsername(String username);

}
