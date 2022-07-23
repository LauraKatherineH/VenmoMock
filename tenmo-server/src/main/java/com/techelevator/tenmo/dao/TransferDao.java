package com.techelevator.tenmo.dao;


import com.techelevator.tenmo.Exceptions.TransferNotCompleteException;
import com.techelevator.tenmo.model.Transfer;

import java.util.List;

public interface TransferDao {

//   Transfer update(Transfer transfer) throws TransferNotCompleteException;

    List<Transfer> listAllTransfers();

    Transfer createTransfer(Transfer transfer, long transferId) throws TransferNotCompleteException;

    Transfer getTransferId(long transfer_type_id) throws TransferNotCompleteException;

    Transfer getTransferType(long transfer_type) throws TransferNotCompleteException;

    Transfer getTransferStatusId(long transfer_status_id) throws TransferNotCompleteException;

    Transfer getAccountFrom(long account_from) throws TransferNotCompleteException;

    Transfer getAccountTo(long account_to) throws TransferNotCompleteException;

    Transfer getTransfer(long transfer_id) throws TransferNotCompleteException;

    Transfer getTransferAmount(Double amount) throws TransferNotCompleteException;


}
//