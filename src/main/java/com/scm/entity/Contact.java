package com.scm.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "contact")
@Getter
@Setter
public class Contact {
    
    private String name;

    @Id
    private String id;
    private String email;
    private String phoneNumber;
    private String address;
    private String description;
    private boolean favourite = false;
    private String picture;
    private String linkedInLinks;

    // private List<SocialLink> SocialLinks = new ArrayList<>();
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "contact" , cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval =  true)
    private List<SocialLink> socialLinks = new ArrayList<>();


}
