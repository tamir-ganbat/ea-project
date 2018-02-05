package edu.mum.domain;

import javax.persistence.*;

/**
 * Created by 985927 on 11/20/2017
 */
@Entity
@Table(name = "person_role",uniqueConstraints = @UniqueConstraint(columnNames = {"role", "person_id"}))
public class PersonRole {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Person person;
    @Column(nullable = false)
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
