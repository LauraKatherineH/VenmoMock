package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.Exceptions.AccountNotFoundException;
import com.techelevator.tenmo.Exceptions.BalanceNotFoundException;
import com.techelevator.tenmo.Exceptions.TransferNotCompleteException;
import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.security.jwt.TokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class AccountController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private AccountDao jdbcAccountDao;
    private UserDao userDao;
    private TransferDao jdbcTransferDao;
    private TransferDao transferDao;


    public AccountController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, AccountDao jdbcAccountDao, UserDao userDao, TransferDao jdbcTransferDao, TransferDao transferDao) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.jdbcAccountDao = jdbcAccountDao;
        this.userDao = userDao;
        this.jdbcTransferDao = jdbcTransferDao;
        this.transferDao = transferDao;
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "account/{id}", method = RequestMethod.GET)
    public Account getAccount(@PathVariable long accountId) throws AccountNotFoundException {
        return jdbcAccountDao.getAccount(accountId);
    }




    // @PreAuthorize("permitAll") //jwt remove permit all
    @RequestMapping(path = "account/balance", method = RequestMethod.GET)
    public Account getBalance(Principal principal) throws BalanceNotFoundException {
        String whoIsAsking = principal.getName();

        int accountIdOfWhoIsAsking = userDao.findAccountByUsername(whoIsAsking);

        return jdbcAccountDao.getBalance(accountIdOfWhoIsAsking);
    }
    @PreAuthorize("permitAll")

    @RequestMapping(path = "account", method = RequestMethod.GET)
    public List<Account> list(Principal principal) throws BalanceNotFoundException{
        String whoIsAsking = principal.getName();

        int accountIdOfWhoIsAsking = userDao.findAccountByUsername(whoIsAsking);

        return jdbcAccountDao.list();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "account/transfer", method = RequestMethod.POST)
    public Transfer addTransfer(@Valid @RequestBody Transfer transfer, Principal principal) throws TransferNotCompleteException {
        String whoIsAsking = principal.getName();
        int accountIdOfWhoIsAsking = userDao.findAccountByUsername(whoIsAsking);
        transfer.setAccountFrom(accountIdOfWhoIsAsking);
        return jdbcTransferDao.createTransfer(transfer, transfer.getTransferId());
    }
//    @RequestMapping( path = "transfer", method = RequestMethod.GET)
//    public Transfer getTransferId(@PathVariable long transferId) throws TransferNotCompleteException {
//        return jdbcTransferDao.getTransfer(transferId);
//    }


@RequestMapping(path = "transfer", method = RequestMethod.GET)
public List<Transfer> listAllTransfers(Principal principal) throws BalanceNotFoundException{
    String whoIsAsking = principal.getName();

    List<Transfer> accountIdOfWhoIsAsking = transferDao.listAllTransfers();

    return jdbcTransferDao.listAllTransfers();
}
}