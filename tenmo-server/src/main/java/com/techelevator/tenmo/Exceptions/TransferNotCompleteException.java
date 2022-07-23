package com.techelevator.tenmo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Wrong account.")
public class TransferNotCompleteException  extends Exception {
    private static final long serialVersionUID = 1l;

    public TransferNotCompleteException() {
        super("Wrong account.");
    }
}