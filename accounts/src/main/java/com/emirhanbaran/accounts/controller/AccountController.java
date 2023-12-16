package com.emirhanbaran.accounts.controller;

import com.emirhanbaran.accounts.constants.AccountConstants;
import com.emirhanbaran.accounts.dto.CustomerDto;
import com.emirhanbaran.accounts.dto.FetchAccountResponseDto;
import com.emirhanbaran.accounts.dto.ResponseDto;
import com.emirhanbaran.accounts.dto.UpdateCustomerDto;
import com.emirhanbaran.accounts.service.IAccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


//produces feature says we are going to produce Json responses from this controller.
@RestController
@RequestMapping(value = "api/v1/account",produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
@Validated
public class AccountController {

    private final IAccountService iAccountService;

    @PostMapping
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){
        iAccountService.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountConstants.STATUS_201,AccountConstants.MESSAGE_201));
    }

    @GetMapping
    public ResponseEntity<FetchAccountResponseDto> fetchCustomerDetails(
            @Size(max = 11, min = 11, message = "The phone number should have 11 digits")
            @RequestParam String mobileNumber){
       FetchAccountResponseDto fetchAccountResponseDto= iAccountService.fetchAccount(mobileNumber);
       return ResponseEntity.status(HttpStatus.OK).body(fetchAccountResponseDto);

    }


    //This is a mock method. It should be implemented...
    @PutMapping
    public  ResponseEntity<ResponseDto> updateCustomer(@RequestBody UpdateCustomerDto updateCustomerDto, @RequestParam String accountNumber){
        iAccountService.updateAccount(updateCustomerDto,accountNumber);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstants.STATUS_200,AccountConstants.MESSAGE_200));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> deleteCustomer(
            @Size(max = 11,min = 11)
            @RequestParam String mobileNumber){
        iAccountService.deleteAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstants.STATUS_200,AccountConstants.MESSAGE_200));
    }
}
