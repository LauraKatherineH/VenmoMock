package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class TransferService {
    private static final String API_BASE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();
    private Transfer transfer = new Transfer();

    public TransferService() {
    }

    // create new transfer
    public Transfer addTransfer(Transfer newTransfer, String jwt) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(jwt);

        HttpEntity<Transfer> entity = new HttpEntity<>(newTransfer, headers);
        Transfer returnedTransfer = null;
        try {
            returnedTransfer = restTemplate.postForObject(API_BASE_URL + "account/transfer", entity, Transfer.class);
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return returnedTransfer;
    }


    //list all users
    public Account[] listAllUsers(String jwt) {
        Account[] accounts = null;

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(jwt);
        // headers.setBearerAuth(currentUser.getToken());
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Void> listOfAllUsers = new HttpEntity<Void>(headers);

        try {
            ResponseEntity<Account[]> response = restTemplate.exchange(API_BASE_URL + "account", HttpMethod.GET, listOfAllUsers, Account[].class);
            accounts = response.getBody();
            for (int i = 0; i < accounts.length; i++) {
                Account originAccount = accounts[i];
                System.out.println("Username: " + originAccount.getUsername() + " Account Id: " + originAccount.getAccountId());

            }

        } catch (RestClientResponseException |
                ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }

        return accounts;


    }

    public double getBalance(String jwt) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(jwt);

        HttpEntity<Void> request = new HttpEntity<>(headers);

        Account result = restTemplate.exchange(API_BASE_URL + "account/balance", HttpMethod.GET, request, Account.class).getBody();
        if (result == null) {
            return 0.0;
        }

        return result.getBalance();
    }

    //find a single transfer by transfer_id
    public Transfer getTransferByTransferId(long transferId) {

        Transfer transfer = null;
        try {
            transfer = restTemplate.getForObject(API_BASE_URL + "account/" + transferId + "/transfer", Transfer.class);
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return transfer;
    }

    // list all transfers by user_id
    public Transfer[] listAllTransfersByUserId(long userId) {
        Transfer[] transfers = null;
        try {
            transfers = restTemplate.getForObject(API_BASE_URL + "account/" + userId + "/transfer", Transfer[].class);
        } catch (RestClientResponseException |
                ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return transfers;
    }

}



