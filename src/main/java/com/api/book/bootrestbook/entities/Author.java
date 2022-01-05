package com.api.book.bootrestbook.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Author {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    @Column(name = "first_name")
    private String firstname;

    private String lastname;

    private String language;

    @OneToOne(cascade = CascadeType.ALL)
   @ JsonBackReference
    private Book book;

    public Author(int authorId, String firstname, String lastname, String language) {
        this.authorId = authorId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.language = language;
    }
    
    public Author() {
    }
    public int getAuthorId() {
        return authorId;
    }
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Author [authorId=" + authorId + ", firstname=" + firstname + ", language=" + language + ", lastname="
                + lastname + "]";
    }
}
