package com.project.customerservice.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "customers")

public class Customer {

    @Id
    private String id;
    private String userCode;
    private short  birthYear;
    private String name;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private double balance;

}
