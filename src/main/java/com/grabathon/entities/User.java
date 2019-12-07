package com.grabathon.entities;

import com.grabathon.enums.OccupationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emailId;
    private String mobileNumber;
    private String firstName;
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    private OccupationType occupationType;

    private Integer monthlyIncomeInThousands;
    private Instant dob;
    private String address;

}
