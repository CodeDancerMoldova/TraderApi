package com.example.TraderApi.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table

public class Trader {
    @Id

    @SequenceGenerator(
            name = "trader_sequence",
            sequenceName = "trader_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trader_sequence"
    )
    private Long id;

    private String name;
    private String city;
    private Long numberOfTransactions;

    public Trader(Long numberOfTransactions, String name, String city) {
        this.numberOfTransactions = numberOfTransactions;
        this.name = name;
        this.city = city;
    }

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
