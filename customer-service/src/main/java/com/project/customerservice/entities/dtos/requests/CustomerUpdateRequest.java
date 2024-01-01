package com.project.customerservice.entities.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerUpdateRequest {

    private String name;
    private String lastName;
    private String userName;
    private String email;
    private String password;
}
