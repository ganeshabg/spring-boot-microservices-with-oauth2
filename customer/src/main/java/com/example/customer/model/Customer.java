package com.example.customer.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
@Entity
@Table(name = "CUSTOMER")
public class Customer  implements Serializable {


    @Id
    @Column(name = "ID",nullable = false)
    private int id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "email_id",nullable = false)
    private String emailId;

    @OneToMany
    @JoinColumn(name = "C_ID",referencedColumnName = "ID")
    private Set<Address> address;

}
