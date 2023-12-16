package com.emirhanbaran.accounts.service.impl;

import com.emirhanbaran.accounts.constants.AccountConstants;
import com.emirhanbaran.accounts.dto.AccountDto;
import com.emirhanbaran.accounts.dto.CustomerDto;
import com.emirhanbaran.accounts.dto.FetchAccountResponseDto;
import com.emirhanbaran.accounts.dto.UpdateCustomerDto;
import com.emirhanbaran.accounts.entity.Account;
import com.emirhanbaran.accounts.entity.Customer;
import com.emirhanbaran.accounts.exception.CustomerAlreadyExistException;
import com.emirhanbaran.accounts.exception.ResourceNotFoundException;
import com.emirhanbaran.accounts.mapper.AccountMapper;
import com.emirhanbaran.accounts.mapper.CustomerMapper;
import com.emirhanbaran.accounts.repository.AccountRepository;
import com.emirhanbaran.accounts.repository.CustomerRepository;
import com.emirhanbaran.accounts.service.IAccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService {

   private final AccountRepository accountRepository;
   private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public void createAccount(CustomerDto customerDto) {
        Customer customer= CustomerMapper.mapToCustomer(customerDto,new Customer());
        Optional<Customer> optionalCustomer=customerRepository.findByMobileNumber(customer.getMobileNumber());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistException("Customer already registered with given Mobile Number "+customer.getMobileNumber());
        }
        Customer savedCustomer=customerRepository.save(customer);
        Account account=createNewAccount(savedCustomer);
        accountRepository.save(account);
        System.out.println("Geçti");
    }

    @Override
    public FetchAccountResponseDto fetchAccount(String mobileNumber) {
        Customer customer=customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()->new ResourceNotFoundException("Customer","Mobile Number",mobileNumber)
        );
        Account account=accountRepository.findByCustomerId(customer.getCustomerId()).
                orElseThrow( ()->new ResourceNotFoundException("Account","Customer ID",customer.getCustomerId().toString()));
        CustomerDto customerDto=CustomerMapper.mapToCustomerDto(customer,new CustomerDto());
        AccountDto accountDto=AccountMapper.mapToAccountsDto(account,new AccountDto());
        return new FetchAccountResponseDto(customerDto,accountDto);

    }

    @Override
    @Transactional
    public void updateAccount(UpdateCustomerDto updateCustomerDto,String accountNumber) {
        Account account=accountRepository.findById(Long.valueOf(accountNumber)).orElseThrow(
                ()-> new ResourceNotFoundException("Account","Account Number",accountNumber)
        );
        Customer customer=customerRepository.findById(account.getCustomerId()).orElseThrow(
                ()-> new ResourceNotFoundException("Customer","Customer ID",account.getCustomerId().toString())
        );
        customer.setName(updateCustomerDto.getName());
        customer.setEmail(updateCustomerDto.getEmail());
        customer.setMobileNumber(updateCustomerDto.getMobileNumber());
        account.setAccountType(updateCustomerDto.getAccountType());
        account.setBranchAddress(updateCustomerDto.getBranchAddress());
        customerRepository.save(customer);
        accountRepository.save(account);
    }

    @Override
    @Transactional
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(()-> new ResourceNotFoundException("Customer","Mobile Number",mobileNumber));
        Account account=accountRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(()-> new ResourceNotFoundException("Account","Customer ID",customer.getCustomerId().toString()));
        customerRepository.delete(customer);
        accountRepository.delete(account);
        return true;
    }

    public Account createNewAccount(Customer customer){
        Account newAccount=new Account();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber=100_000_000_0L+new Random().nextInt(900_000_000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);

        return newAccount;
    }



}
