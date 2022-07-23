package com.techelevator.tenmo.model;

public class Account {

    private long accountId;
    private long userId;
    private double balance;

    public String getUsername() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    private String username;

    public Account(long accountId, long userId, double balance) {
        this.accountId = accountId;
        this.userId = userId;
        this.balance = balance;
    }

    public Account() {

    }

    public long getAccountId() {
        return accountId;
    }

    public long getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    //so far tried Long userId in ()


    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}


