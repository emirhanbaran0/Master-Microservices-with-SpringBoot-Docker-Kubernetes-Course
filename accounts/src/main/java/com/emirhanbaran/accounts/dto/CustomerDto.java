package com.emirhanbaran.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer information"
)
public class CustomerDto {

    @Schema(
            name = "Customer's name",
            description = "Field to hold Customer's name information"
    )
    private String name;
    @Schema(
            name = "Customer's email",
            description = "Field to hold Customer's email information"
    )
    private String email;
    @Schema(
            name = "Customer's mobile number",
            description = "Field to hold Customer's mobile number information"
    )
    private String mobileNumber;

}
