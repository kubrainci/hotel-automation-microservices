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

    @NotNull(message = "Doğum tarihiniz boş bırakılamaz.")
    private short  birthYear;
    @NotBlank(message = "Kullanıcı adınız boş bırakılamaz")
    private String name;

    @NotBlank(message = "Kullanıcı soy isminiz boş bırakılamaz.")
    private String lastName;

    @NotBlank(message = "Kullanıcı isminiz boş bırakılamaz")
    @Size(min = 3,max = 10,message = "Kullanıcı adı minimum 3 maksimum 10 haneden oluşmalıdır.")
    private String userName;

    @NotBlank(message = "Lütfen Gmail hesabınızı yazın.")
    @Email(
            message = "Email gecerli degil.",
            regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    @NotBlank(message = "Lütfen şifre oluşturun.")
    private String password;
}
