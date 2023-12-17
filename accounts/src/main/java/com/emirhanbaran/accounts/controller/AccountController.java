package com.emirhanbaran.accounts.controller;

import com.emirhanbaran.accounts.constants.AccountConstants;
import com.emirhanbaran.accounts.dto.*;
import com.emirhanbaran.accounts.service.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(
        name = "CRUD REST APIs for Accounts in EazyBank",
        description = "CRUD REST APIs in EazyBank to CREATE,UPDATE,FETCH AND DELETE account details"
)
public class AccountController {

    private final IAccountService iAccountService;

    @PostMapping("/")
    @Operation(
            summary = "Create Account Rest API",
            description = "REST API to create new Customer & Account inside EazyBank"
    )
    @ApiResponse(
            responseCode = "201",
            description = " HTTP Status Created"
    )
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){
        iAccountService.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountConstants.STATUS_201,AccountConstants.MESSAGE_201));
    }



    @GetMapping("/")
    @Operation(
            summary = "Fetch Account Details REST API",
            description = "REST API to fetch Customer & Account details based on a mobile number"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK"
    )
    public ResponseEntity<FetchAccountResponseDto> fetchCustomerDetails(
            @Size(max = 11, min = 11, message = "The phone number should have 11 digits")
            @RequestParam String mobileNumber){
       FetchAccountResponseDto fetchAccountResponseDto= iAccountService.fetchAccount(mobileNumber);
       return ResponseEntity.status(HttpStatus.OK).body(fetchAccountResponseDto);

    }


    //This is a mock method. It should be implemented...
    @PutMapping("/")
    @Operation(
            summary = "Update Account Details REST API",
            description = "REST API to update Customer & Account details based on a mobile number"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "HTTP Status OK"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "HTTP Status Internal Server Error",
                            //Since the ErrorResponseDto is only throwing by global exception handler
                            // we should provide this @Content annotation to see it in our swagger documentation
                            content = @Content(
                                    schema = @Schema(implementation = ErrorResponseDto.class)
                            )

                    )
            }

    )
    public  ResponseEntity<ResponseDto> updateCustomer(@RequestBody UpdateCustomerDto updateCustomerDto, @RequestParam String accountNumber){
        iAccountService.updateAccount(updateCustomerDto,accountNumber);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstants.STATUS_200,AccountConstants.MESSAGE_200));
    }

    @DeleteMapping("/")
       @Operation(
            summary = "Delete Customer REST API",
            description = "REST API to delete customer based on a mobile number"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "HTTP Status OK"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "HTTP Status Internal Server Error"
                    )
            }

    )
    public ResponseEntity<ResponseDto> deleteCustomer(
            @Size(max = 11,min = 11)
            @RequestParam String mobileNumber){
        iAccountService.deleteAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstants.STATUS_200,AccountConstants.MESSAGE_200));
    }
}
