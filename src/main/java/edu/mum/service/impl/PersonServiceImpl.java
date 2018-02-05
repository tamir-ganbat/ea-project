package edu.mum.service.impl;

import edu.mum.domain.Person;
import edu.mum.repository.PersonRepo;
import edu.mum.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 985927 on 11/20/2017
 */
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepo personRepo;

    @Autowired
    public PersonServiceImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public void save(Person person) {
        personRepo.save(person);
    }

    @Override
    public void update(Person person) {
        personRepo.update(person);
    }

    @Override
    public List<Person> find() {
        return personRepo.find();
    }

    @Override
    public Person get(Integer id) {
        return personRepo.get(id);
    }

    @Override
    public Person findByUsername(String username) {
        return personRepo.findByUsername(username);
    }
}
