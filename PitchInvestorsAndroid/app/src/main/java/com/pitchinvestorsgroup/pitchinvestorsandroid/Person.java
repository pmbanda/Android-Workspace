package com.pitchinvestorsgroup.pitchinvestorsandroid;

/**
 * Created by Eugene & Diane on 1/24/2018.
 */

public class Person
{
    private int id;
    private double amount;
    private String email;
    private String name;
    private String position;

    public Person(double amount, String email, String name, String position) {
        this.amount = amount;
        this.email = email;
        this.name = name;
        this.position = position;
    }

    public Person() {
    }

    public double getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Person{ " +
                "Id =" + this.id +
                "Amount =" + this.amount +
                ", Email ='" + this.email + '\'' +
                ", Name ='" + this.name + '\'' +
                ", Position ='" + this.position + '\'' +
               '}';
    }
}
