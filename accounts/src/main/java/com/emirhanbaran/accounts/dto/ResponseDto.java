package com.emirhanbaran.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
@Schema(
        name = "Successful Response",
        description = "Schema to Give a successful response to the client"
)
public class ResponseDto {

    @Schema(
            name = "Response Status Code",
            description = "Field to hold response status code",
            example = "200"
    )
    private String statusCode;
    @Schema(
            name = "Response Message",
            description = "Field to hold response message",
            example = "COMPLETED SUCCESSFULLY"
    )
    private String statusMsg;
}
