
package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String owner;
    private double balance;

    public Account() {}
    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
