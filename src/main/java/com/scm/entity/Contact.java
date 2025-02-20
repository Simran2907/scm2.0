package com.scm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private User user;

}
