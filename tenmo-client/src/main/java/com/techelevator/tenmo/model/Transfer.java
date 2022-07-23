package com.techelevator.tenmo.model;

public class Transfer {

    private long transferId;
    private long transferType;
    private long transferStatusId;
    private long accountFrom;
    private long accountTo;
    private double amount;


    public Transfer(long transferId, long transferType, long transferStatusId, long accountFrom, long accountTo, double amount) {
        this.transferId = transferId;
        this.transferType = transferType;
        this.transferStatusId = transferStatusId;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    public Transfer(){}

    public long getTransferId() {
        return transferId;
    }

    public void setTransferId(long transferId) {
        this.transferId = transferId;
    }

    public long getTransferType() {
        return transferType;
    }

    public void setTransferType(long transferType) {
        this.transferType = transferType;
    }

    public long getTransferStatusId() {
        return transferStatusId;
    }

    public void setTransferStatusId(long transferStatusId) {
        this.transferStatusId = transferStatusId;
    }

    public long getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(long accountFrom) {
        this.accountFrom = accountFrom;
    }

    public long getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(long accountTo) {
        this.accountTo = accountTo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
