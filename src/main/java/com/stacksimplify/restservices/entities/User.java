package com.stacksimplify.restservices.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String role;
    private String ssn;


}
