package com.cevenant.backend.data.person;


import com.cevenant.backend.data.address.Address;
import com.cevenant.backend.data.donation.Donation;
import com.cevenant.backend.data.organization.Organization;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table( name = "PERSON" )
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Person {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "PERSON_ID" )
    private long Id;
    @Column( name = "FIRST_NAME" )
    private String firstName;
    @Column( name = "MIDDLE_NAME" )
    private String middleName;
    @Column( name = "LAST_NAME" )
    private String lastName;
    @Column( name = "FAMILY")
    private ArrayList<Person> family;
     @Column( name = "DATE_JOINED" )
    private Date dateJoined;
    @Column( name = "CELLPHONE" )
    private String cellPhone;
    @Column( name = "MARITAL_STATUS" )
    private String maritalStatus;
    @Column( name = "ACTIVE_STATUS" )
    private Boolean active;
    @Column( name = "MEMBER_TYPE" )
    private String memberType;
    @Column( name = "EMAIL_ADDRESS" )
    private String emailAddress;
    @Column( name = "BIRTH_DATE" )
    private Date birthDate;
    @ManyToMany( cascade = CascadeType.ALL )
    @JoinTable(
            name = "ADDRESS_LINK",
            joinColumns = @JoinColumn( name = "PERSON_ID" ),
            inverseJoinColumns = @JoinColumn( name = "ADDRESS_ID" )
    )
    Set<Address> addresses;
    @ManyToMany( mappedBy = "people" )
    private Set<Organization> organizations;

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Donation> donations;


    public Person() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Person> getFamily() {
        return family;
    }

    public void setFamily(ArrayList<Person> family) {
        this.family = family;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
    }

    public Set<Donation> getDonations() {
        return donations;
    }

    public void setDonations(Set<Donation> donations) {
        this.donations = donations;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", family=" + family +
                ", dateJoined=" + dateJoined +
                ", cellPhone='" + cellPhone + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", active=" + active +
                ", memberType='" + memberType + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", birthDate=" + birthDate +
                ", addresses=" + addresses +
                '}';
    }
}
