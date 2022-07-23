package com.techelevator.tenmo.model;

public class Transfer {

    private long transferId;
    private long transferType;
    private long transferStatusId;
    private long accountFrom;
    private long accountTo;
    private double amount;

    public Transfer (long transferId, long transferType, long transferStatusId, long accountFrom, long accountTo, double amount){
        this.transferId = transferId;
        this.transferType = transferType;
        this.transferStatusId = transferStatusId;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    public Transfer() {

    }

    public long getTransferId() {
        return transferId;
    }

    public long getTransferType() {
        return transferType;
    }

    public long getTransferStatusId() {
        return transferStatusId;
    }

    public long getAccountFrom() {
        return accountFrom;
    }

    public long getAccountTo() {
        return accountTo;
    }

    public void setTransferId(long transferId) {
        this.transferId = transferId;
    }

    public void setTransferType(long transferType) {
        this.transferType = transferType;
    }

    public void setTransferStatusId(long transferStatusId) {
        this.transferStatusId = transferStatusId;
    }

    public void setAccountFrom(long accountFrom) {
        this.accountFrom = accountFrom;
    }

    public void setAccountTo(long accountTo) {
        this.accountTo = accountTo;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
