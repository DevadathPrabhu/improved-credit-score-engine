package com.grabathon.entities;

import com.grabathon.enums.ExpenseAffectType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String expenseValue;

    @Enumerated(value = EnumType.STRING)
    private ExpenseAffectType effectType;

    private BigDecimal effectValue;

}
