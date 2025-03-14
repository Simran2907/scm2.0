package com.scm.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_name",length = 50,nullable =false)
    private String name;

    @Column(unique = true,nullable = false)
    private String email;
    private String password;
    private String about;
    private String profilePic;
    private String phoneNumber;

    //information
    private boolean enabled = false;
    private boolean emailVerfied = false;
    private boolean phoneVerfied = false;

    //SELF,GOOGLE,FACEBOOK,GITHUB
    private Providers provider = Providers.SELF;
    private String providerUserId;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval =  true)
    private List<Contact> contacts = new ArrayList<>();

}
