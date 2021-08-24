package se.nackademin.java20.lab1.Persistance.model;

import javax.persistence.*;

/**
 * Created by Daniel Bojic
 * Date: 2021-08-24
 * Time: 15:51
 * Project: Lab1
 * Copyright: MIT
 */

@Entity
public class Person {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "balance")
    private int balance;

    @Column(name = "name")
    private String name;

    public Person(){

    }

    public Person(long id, String name, int balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public void withdraw(int balance){
        this.balance -= balance;
    }

    public void deposit(int deposit){
        this.balance += deposit;
    }




    public long getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}
