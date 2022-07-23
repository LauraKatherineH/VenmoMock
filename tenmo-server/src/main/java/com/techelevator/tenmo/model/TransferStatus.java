package com.techelevator.tenmo.model;

public class TransferStatus {

    private long transferTypeID;
    private String transferTypeDesc;


    public TransferStatus(long transferTypeID, String transferTypeDesc){
        this.transferTypeID = transferTypeID;
        this.transferTypeDesc = transferTypeDesc;
    }

    public long getTransferTypeID() {
        return transferTypeID;
    }

    public void setTransferTypeID(long transferTypeID) {
        this.transferTypeID = transferTypeID;
    }

    public String getTransferTypeDesc() {
        return transferTypeDesc;
    }

    public void setTransferTypeDesc(String transferTypeDesc) {
        this.transferTypeDesc = transferTypeDesc;
    }
}

