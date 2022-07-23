package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.Exceptions.AccountNotFoundException;
import com.techelevator.tenmo.Exceptions.BalanceNotFoundException;

import java.util.List;
import com.techelevator.tenmo.model.Account;

public interface AccountDao {

    List<Account> list();

    Account getBalance(long accountId) throws BalanceNotFoundException;


  //  Account update(Double balance) throws BalanceNotFoundException;

    Account getAccount(long accountId) throws AccountNotFoundException;

    Account getAccountByUserId(long userID) throws AccountNotFoundException;


}
