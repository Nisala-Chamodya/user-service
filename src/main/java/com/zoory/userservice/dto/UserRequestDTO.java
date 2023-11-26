package com.zoory.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequestDTO {

    private String userName;

    private String nicNo;
    private byte[] nicImg;
    private byte[] paymentSlipImg;
    private int age;
    private String gender;
    private String email;
    private String contactNo;
    private String address;
    private String password;
}
