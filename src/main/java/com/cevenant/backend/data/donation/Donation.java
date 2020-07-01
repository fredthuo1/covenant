package com.cevenant.backend.data.donation;

import com.cevenant.backend.data.person.Person;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table( name = "DONATION" )
public class Donation {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "DONATION_ID" )
    private Long Id;
    @Column( name = "DONATION_NAME" )
    private String donation_name;
    @ManyToOne( fetch = FetchType.LAZY )
    private Person person;
    @Column( name = "AMOUNT")
    private BigDecimal amount;
    @Column( name = "TYPE" )
    private String type;

    public Donation() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDonation_name() {
        return donation_name;
    }

    public void setDonation_name(String donation_name) {
        this.donation_name = donation_name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "Id=" + Id +
                ", donation_name='" + donation_name + '\'' +
                ", person=" + person +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}
