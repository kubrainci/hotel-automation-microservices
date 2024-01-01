package com.project.customerservice.entities.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerAddRequest {

    private String name;
    private String lastName;
    private String userName;
    private String email;
    private String password;
}
