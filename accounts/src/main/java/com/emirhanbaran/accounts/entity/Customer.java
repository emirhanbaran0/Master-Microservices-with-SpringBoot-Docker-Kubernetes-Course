package com.emirhanbaran.accounts.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter@Setter@ToString
@Table(name="customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Size(max = 100)
    @NotEmpty(message = "Name cannot be empty or null")
    private String name;

    @Email
    @Size(max = 100)
    @NotEmpty(message = "Email Cannot be Null or Empty")
    private String email;

    @NotEmpty(message = "Phone Number cannot be null or Empty")
    private String mobileNumber;



}
