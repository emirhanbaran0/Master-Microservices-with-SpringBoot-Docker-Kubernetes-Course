package com.emirhanbaran.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(
        name = "Customer Update",
        description = "Schema using for updating Customer's information"
)
public class UpdateCustomerDto {

    private String name;
    private  String email;
    private  String mobileNumber;
    private String accountType;
    private String branchAddress;
}
