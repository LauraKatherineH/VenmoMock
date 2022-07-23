//package com.techelevator.tenmo.controller;
//
//
//import com.techelevator.tenmo.Exceptions.TransferNotCompleteException;
//import com.techelevator.tenmo.dao.AccountDao;
//import com.techelevator.tenmo.dao.TransferDao;
//import com.techelevator.tenmo.dao.UserDao;
//import com.techelevator.tenmo.model.Account;
//import com.techelevator.tenmo.model.Transfer;
//import com.techelevator.tenmo.security.jwt.TokenProvider;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//
//
//
//
//
//@RestController
//@PreAuthorize("isAuthenticated()")
//public class TransferController {
//
//    private TransferDao jdbcTransferDao;
//    private AccountDao jdbcAccountDao;
//    private UserDao userDao;
//
//    public TransferController(TransferDao jdbcTransferDao, AccountDao jdbcAccountDao, UserDao userDao) {
//        this.jdbcTransferDao = jdbcTransferDao;
//        this.jdbcAccountDao = jdbcAccountDao;
//        this.userDao = userDao;
//    }
//
//    public TransferController(TransferDao jdbcTransferDao) {
//        this.jdbcTransferDao = jdbcTransferDao;
//    }
//
//    public TransferController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, AccountDao jdbcAccountDao, UserDao userDao) {
//
//        this.jdbcAccountDao = jdbcAccountDao;
//        this.userDao = userDao;
//    }
//
//
//// list transfers
// @ResponseStatus(HttpStatus.CREATED)
////    @RequestMapping( path = "/reservations", method = RequestMethod.POST)
////    public Transfer addTransfer(@Valid @RequestBody Transfer transfer) throws TransferNotCompleteException {
////        return jdbcTransferDao.createTransfer(transfer, transfer.getTransferId());
////    }
//
//
//
//    // create transfers
//
//
//
//
//}
