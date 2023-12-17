package com.emirhanbaran.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(
        name = "Account",
        description = "Schema to hold Account information "
)
public class AccountDto {

    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}
