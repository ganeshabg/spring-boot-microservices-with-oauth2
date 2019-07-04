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
@Table(name = "Role")
public class Role implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ROLE_PERMISSION",
            joinColumns = {
                @JoinColumn(name = "role_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                 @JoinColumn(name = "permission_id", referencedColumnName = "id")
            })
    private List<Permission> permissions;
}
