package com.emirhanbaran.accounts.entity;

import com.emirhanbaran.accounts.entity.BaseClass;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
@Entity
@Table(name="account")
public class Account extends BaseClass {

    @NotNull
    @Column(name = "customer_id")
    private Long id;
    @Id  //We will generate our own Id's
    @Column(name = "account_number")
    private Long accountNumber;
    @NotNull
    @Column(name = "account_type")
    @Size(max = 100)
    private String accountType;
    @NotNull
    @Column(name = "branch_address")
    @Size(max = 200)
    private String branchAddress;





}
