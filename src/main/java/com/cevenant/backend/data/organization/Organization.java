package com.cevenant.backend.data.organization;

import com.cevenant.backend.data.address.Address;
import com.cevenant.backend.data.person.Person;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table( name = "ORGANIZATION" )
public class Organization {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "ORGANIZATION_ID" )
    private Long Id;
    @Column( name = "ORGANIZATION_NAME" )
    private String organization_name;

    @ManyToMany( cascade = CascadeType.ALL )
    @JoinTable(
            name = "ORGANIZATION_ADDRESS_LINK",
            joinColumns = @JoinColumn( name = "ORGANIZATION_ID" ),
            inverseJoinColumns = @JoinColumn( name = "ADDRESS_ID" )
    )
    private Set<Address>  organization_addresses;

    @ManyToMany( cascade = CascadeType.ALL )
    @JoinTable(
            name = "PERSON_LINK",
            joinColumns = @JoinColumn( name = "ORGANIZATION_ID" ),
            inverseJoinColumns = @JoinColumn( name = "PERSON_ID" )
    )
    private Set<Person> people;

    public Organization() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getOrganization_name() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
    }

    public Set<Address> getOrganization_addresses() {
        return organization_addresses;
    }

    public void setOrganization_addresses(Set<Address> organization_addresses) {
        this.organization_addresses = organization_addresses;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }
}
