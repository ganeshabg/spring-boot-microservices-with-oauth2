package com.example.customer.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
@Entity
@Table(name = "Address")
public class Address implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "c_id")
    private int customer_id;

    @Column(name = "address_first_line")
    private String address_first_line;

    @Column(name = "address_last_line")
    private String address_last_line;

    @Column(name = "pincode")
    private String pincode;


}
