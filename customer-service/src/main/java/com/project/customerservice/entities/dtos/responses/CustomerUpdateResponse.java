package com.project.customerservice.entities.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerUpdateResponse {

    private String name;
    private String lastName;
    private String userName;
    private String email;
}
