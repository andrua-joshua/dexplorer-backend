package com.dhotels.hotelsbackend.modules;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name = "TRANSACTIONS")
@NoArgsConstructor
@Setter
@Getter
public class Transaction {

    @Id
    @GeneratedValue
    private Integer id;
    private String transactionId;
    private String type;
    @ManyToOne
    @JoinColumn(name = "owner-id", referencedColumnName = "id")
    @JsonIgnore
    private User owner;
    private double amount;


    public Transaction(String transactionId, User owner, String type, double amount) {
        this.transactionId = transactionId;
        this.owner = owner;
        this.type = type;
        this.amount = amount;
    }
}
