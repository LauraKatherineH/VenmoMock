package com.techelevator.tenmo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED, reason = "Insufficient funds.")
public class BalanceNotFoundException  extends Exception {
    private static final long serialVersionUID = 1l;

    public BalanceNotFoundException() { super("Insufficient funds."); }



}

