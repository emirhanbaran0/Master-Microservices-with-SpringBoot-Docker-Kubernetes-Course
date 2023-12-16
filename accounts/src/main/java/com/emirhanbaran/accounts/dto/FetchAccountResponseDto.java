package com.emirhanbaran.accounts.dto;

import lombok.Data;

@Data
public class FetchAccountResponseDto {

    private String name;
    private  String email;
    private  String mobileNumber;
    private Long accountNumber;
    private String accountType;
    private String branchAddress;

    public FetchAccountResponseDto(CustomerDto customerDto, AccountDto accountDto) {
        this.name=customerDto.getName();
        this.email=customerDto.getEmail();
        this.mobileNumber=customerDto.getMobileNumber();
        this.accountNumber=accountDto.getAccountNumber();
        this.accountType=accountDto.getAccountType();
        this.branchAddress=accountDto.getBranchAddress();
    }
}
