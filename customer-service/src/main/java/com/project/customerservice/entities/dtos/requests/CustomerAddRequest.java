package com.project.customerservice.entities.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerAddRequest {

    @NotNull(message = "{DateOfBirthCannotBeLeftBlank}")
    private Date birthYear;

    @NotBlank(message = "{UserCodeCannotBeLeftBlank}")
    @Size(min = 3,max = 5,message = "{UserCodeMustMatchTheNumberOfCharacters}")
    private String userCode;

    @NotBlank(message = "{NameCannotBeLeftBlank}")
    private String name;

    @NotBlank(message = "{UserLastNameCannotBeLeftBlank}")
    private String lastName;

    @NotBlank(message = "{UserNameCannotBeLeftBlank}")
    @Size(min = 3,max = 10,message = "{UserNameMustMatchTheNumberOfCharacters}")
    private String userName;

    @NotBlank(message = "{GmailCannotBeLeftBlank}")
    @Email(
            message = "{EmailIsInvalid}",
            regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @NotBlank(message = "{PasswordCannotBeLeftBlank}")
    @Size(min = 5,max = 20,message = "{PasswordMustMatchTheNumberOfCharacters}")
    private String password;
}
