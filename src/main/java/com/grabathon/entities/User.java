package com.grabathon.entities;

import com.grabathon.enums.OccupationType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emailId;
    private String mobileNumber;
    private String firstName;
    private String lastName;
    private OccupationType occupationType;
    private Integer monthlyIncomeInThousands;

}
