package com.emirhanbaran.accounts.service;

import com.emirhanbaran.accounts.dto.CustomerDto;
import com.emirhanbaran.accounts.dto.FetchAccountResponseDto;
import com.emirhanbaran.accounts.dto.UpdateCustomerDto;

public interface IAccountService {

    /**
     *
     * @param customerDto -CustomerDto Object
     */
    public void createAccount(CustomerDto customerDto);

    FetchAccountResponseDto fetchAccount(String mobileNumber);
    void updateAccount(UpdateCustomerDto updateCustomerDto,String accountNumber);

    boolean deleteAccount(String mobileNumber);

}
