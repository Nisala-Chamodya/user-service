package com.zoory.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    private String userId;
    private String userName;
    private String nicNo;
    @Lob
    @Column(nullable = false,columnDefinition = "LONGBLOB",length = 655555555)
    private byte[] nicImg;
    @Lob
    @Column(nullable = false,columnDefinition = "LONGBLOB",length = 655555555)
    private byte[] paymentSlipImg;
    private int age;
    private String gender;
    private String email;
    private String contactNo;
    private String address;
    private String password;
}
