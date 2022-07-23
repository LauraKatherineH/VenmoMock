package com.techelevator.tenmo.model;

public class Account {

    private long accountId;
    private long userId;
    private double balance;
    private String username;

    public Account() {

    }

    @Override
    public String toString() {
        return "\n---------" +
                "\n Account Details" +
                "\n---------" +
                "\n id " + accountId +
                "\n userID " + userId +
                "\n balance " + balance;
    }

    public String getUsername() {
        return username;
    }




    public void setUsername(String username) {
        this.username = username;
    }

    public Account(long accountId, long userId, double balance) {
        this.accountId = accountId;
        this.userId = userId;
        this.balance = balance;
        this.username = username;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
