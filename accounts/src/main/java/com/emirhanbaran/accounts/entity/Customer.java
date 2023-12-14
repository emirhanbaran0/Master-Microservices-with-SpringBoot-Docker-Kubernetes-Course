package com.emirhanbaran.accounts.entity;

import com.emirhanbaran.accounts.entity.BaseClass;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull
    private String name;

    @Email
    @Size(max = 100)
    @NotNull
    private String email;

    @NotNull
    @Size(max = 20)
    private String mobileNumber;



}
