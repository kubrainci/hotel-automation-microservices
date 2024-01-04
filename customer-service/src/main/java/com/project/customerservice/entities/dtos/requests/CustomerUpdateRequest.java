package com.project.customerservice.entities.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerUpdateRequest {

    @NotNull(message = "{DateOfBirthCannotBeLeftBlank}")
    private short  birthYear;

    @NotBlank(message = "{NameCannotBeLeftBlank}")
    private String name;

    @NotBlank(message = "{UserLastNameCannotBeLeftBlank}")
    private String lastName;

    @NotBlank(message = "{UserNameCannotBeLeftBlank}")
    @Size(min = 3,max = 10,message = "Kullanıcı adı minimum 3 maksimum 10 haneden oluşmalıdır.")
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
