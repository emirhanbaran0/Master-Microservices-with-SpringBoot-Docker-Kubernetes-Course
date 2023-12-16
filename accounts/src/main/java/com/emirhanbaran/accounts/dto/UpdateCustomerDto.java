package com.emirhanbaran.accounts.dto;

import lombok.Data;

@Data
public class UpdateCustomerDto {

    private String name;
    private  String email;
    private  String mobileNumber;
    private String accountType;
    private String branchAddress;
}
