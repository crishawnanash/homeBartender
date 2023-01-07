package org.launchcode.homeBartender.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
//this allows you to ignore all values that are null
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class SignUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String email;

    @Column
    private String birthdate;

    @Column
    private String image;


}