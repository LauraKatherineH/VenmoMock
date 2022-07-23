//package com.techelevator.tenmo.services;
//
//import com.techelevator.tenmo.model.Account;
//import com.techelevator.tenmo.model.AuthenticatedUser;
//import com.techelevator.util.BasicLogger;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.ResourceAccessException;
//import org.springframework.web.client.RestClientResponseException;
//import org.springframework.web.client.RestTemplate;
//
//public class AccountService {
//
//    private static  String API_BASE_URL = "http://localhost:8080/";
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    private String authToken = null;
//
//   public AccountService(String url){
//       this.API_BASE_URL = url;
//   }
//
//
//    public void setAuthToken(String authToken) {
//        this.authToken = authToken;
//    }
//
//    public AccountService(String API_BASE_URL, AuthenticatedUser currentUser) {
//    }
//
//    public Account[] listAccounts() {
//        Account[] accounts = null;
//
//        try { ResponseEntity<Account[]> response = restTemplate.exchange(API_BASE_URL + "account",
//                HttpMethod.GET, makeAuthEntity(), Account[].class);
//            accounts = response.getBody();
//        } catch (RestClientResponseException | ResourceAccessException e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return accounts;
//    }
//
//
//
//    public Account getBalance(long id) {
//        Account account = new Account();
//        try {
//            account = restTemplate.exchange(API_BASE_URL + "account/" + id, HttpMethod.GET, makeAuthEntity(), Account.class).getBody();
//           // account = response.getBody();
//        } catch (RestClientResponseException | ResourceAccessException e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return account;
//    }
//
//
//    private HttpEntity<Void> makeAuthEntity() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBearerAuth(authToken);
//        return new HttpEntity<>(headers);
//    }
//
//}
