package com.example.oauth2.authorizationserver.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "User")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "enabled")
    private int enabled;
    @Column(name = "accountNonExpired")
    private int accountNonExpired;
    @Column(name = "credentialsNonExpired")
    private int credentialsNonExpired;
    @Column(name = "accountNonLocked")
    private int accountNonLocked;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ROLE_USER", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;


}
