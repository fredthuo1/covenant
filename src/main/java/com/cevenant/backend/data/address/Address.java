package com.cevenant.backend.data.address;

import com.cevenant.backend.data.organization.Organization;
import com.cevenant.backend.data.person.Person;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table( name = "ADDRESS" )
public class Address {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "ADDRESS_ID" )
    private long addressId;
    @Column( name = "STREET" )
    private String street;
    @Column( name = "CITY" )
    private String city;
    @Column( name = "STATE" )
    private String state;
    @Column( name = "ZIP_CODE" )
    private String zipCode;
    @Column( name = "COUNTRY" )
    private String country;
    @ManyToMany( mappedBy = "addresses" )
    private Set<Person> people;
    @ManyToMany( mappedBy = "organization_addresses" )
    private Set<Organization> organizations;

    public Address() {
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

    public Set<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
