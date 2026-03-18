package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "CustomerDetails",
        description = "Schema to hold Customer, Account, Cards and Loans information"
)
public class CustomerDetailsDto {

    @Schema(
            description = "Name of the customer",
            example = "Paco RG"
    )
    @NotEmpty(message = "Name can't be a null or empty.")
    @Size(min=5,max=50,message = "The length of the customer name should be between 5 and 30.")
    private String name;

    @Schema(
            description = "Email address of the customer",
            example = "pacorg@gmail.com"
    )
    @NotEmpty(message = "E-mail address can't be null or empty")
    @Email(message = "Type a correct email address")
    private String email;

    @Schema(
            description = "Mobile number of the customer",
            example = "5512345678"
    )
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number must be 10 digits. Numbers only.")
    private String mobileNumber;

    @Schema(
            description = "Account details of the customer"
    )
    private AccountDto accountDto;

    @Schema(
            description = "Card details of the customer"
    )
    private CardsDto cardsDto;

    @Schema(
            description = "Loan details of the customer"
    )
    private LoansDto loansDto;
}
