
package com.example.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class TransactionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int fromAccountId;
    private int toAccountId;
    private double amount;
    private Date date;

    public TransactionRecord() {}
    public TransactionRecord(int fromAccountId, int toAccountId, double amount, Date date) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.date = date;
    }

    // Getters and setters omitted for brevity
}
