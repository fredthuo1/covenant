package com.cevenant.backend.data.nylas;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table( name = "NYLAS")
public class Nylas {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "ID" )
    private long Id;
    @Column( name = "CLIENT_ID" )
    private String clientId;
    @Column( name = "CLIENT_SECRET" )
    private String clientSecret;
    @Column( name = "REDIRECT_URL" )
    private String url;
    @Column( name = "TOKEN" )
    private String token;
    @Column( name = "SCOPES" )
    private ArrayList scopes;
    @Column( name = "EMAIL_STATE" )
    private  String emailState;
    @Column( name = "ACCESS_TOKEN" )
    private String accessToken;
    @Column( name = "SUBJECT")
    private String subject;
    @Column( name = "NAME_FROM" )
    private String name_from;
    @Column( name = "EMAIL_FROM" )
    private String emailFrom;
    @Column( name = "NAME_TO" )
    private String name_to;
    @Column( name = "EMAIL_TO" )
    private String emailTo;
    @Column( name = "BODY" )
    private String body;
    @Column( name = "CC" )
    private ArrayList cc;
    @Column( name = "ATTACHMENT" )
    private String attachment;
    @Column( name = "DETACHMENT" )
    private String detachment;

    public Nylas() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ArrayList getScopes() {
        return scopes;
    }

    public void setScopes(ArrayList scopes) {
        this.scopes = scopes;
    }

    public String getEmailState() {
        return emailState;
    }

    public void setEmailState(String emailState) {
        this.emailState = emailState;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName_from() {
        return name_from;
    }

    public void setName_from(String name_from) {
        this.name_from = name_from;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getName_to() {
        return name_to;
    }

    public void setName_to(String name_to) {
        this.name_to = name_to;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ArrayList getCc() {
        return cc;
    }

    public void setCc(ArrayList cc) {
        this.cc = cc;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getDetachment() {
        return detachment;
    }

    public void setDetachment(String detachment) {
        this.detachment = detachment;
    }

    @Override
    public String toString() {
        return "Nylas{" +
                "Id=" + Id +
                ", clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", url='" + url + '\'' +
                ", token='" + token + '\'' +
                ", scopes=" + scopes +
                ", emailState='" + emailState + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", subject='" + subject + '\'' +
                ", name_from='" + name_from + '\'' +
                ", emailFrom='" + emailFrom + '\'' +
                ", name_to='" + name_to + '\'' +
                ", emailTo='" + emailTo + '\'' +
                ", body='" + body + '\'' +
                ", cc=" + cc +
                ", attachment='" + attachment + '\'' +
                ", detachment='" + detachment + '\'' +
                '}';
    }
}
