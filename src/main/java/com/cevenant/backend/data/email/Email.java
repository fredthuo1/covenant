package com.cevenant.backend.data.email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "EMAIL" )
public class Email {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "EMAIL_ID" )
    private long Id;
    @Column( name = "SENDER" )
    private String sender;
    @Column( name = "RECIPIENT" )
    private String recipient;
    @Column( name = "CC" )
    private String cc;
    @Column( name = "SUBJECT" )
    private String subject;
    @Column( name = "MESSAGE" )
    private String message;

    public Email( ) {
    }


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Email{" +
                "Id=" + Id +
                ", sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", cc='" + cc + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
