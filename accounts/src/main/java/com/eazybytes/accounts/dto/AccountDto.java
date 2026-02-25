package com.eazybytes.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data

public class AccountDto {

    @NotEmpty(message = "Account number can't be a null or empty.")
    @Pattern(regexp = "(^$[0-9]{10})",message = "Account number must be 10 digits. Numbers only.")
    private Long accountNumber;

    @NotEmpty(message = "Account type number can't be a null or empty.")
    private String accountType;

    @NotEmpty(message = "Branch address can't be a null or empty.")
    private String branchAddress;

}
