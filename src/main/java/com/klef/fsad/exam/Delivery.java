package com.klef.fsad.exam;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="delivery")
public class Delivery 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String status;
    private String address;
    private double amount;

    public Delivery() {}

    public Delivery(String name, Date date, String status, String address, double amount) {
        this.name = name;
        this.date = date;
        this.status = status;
        this.address = address;
        this.amount = amount;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}