package com.techelevator.tenmo;

import com.techelevator.tenmo.model.*;
import com.techelevator.tenmo.services.AuthenticationService;
import com.techelevator.tenmo.services.ConsoleService;
import com.techelevator.tenmo.services.TransferService;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.math.BigDecimal;


public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";

    private final ConsoleService consoleService = new ConsoleService();
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);
    private final TransferService transferService = new TransferService();
    private AuthenticatedUser currentUser;

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        consoleService.printGreeting();
        loginMenu();
        if (currentUser != null) {
            mainMenu();
        }
    }

    private void loginMenu() {
        int menuSelection = -1;
        while (menuSelection != 0 && currentUser == null) {
            consoleService.printLoginMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                handleRegister();
            } else if (menuSelection == 2) {
                handleLogin();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
                consoleService.pause();
            }
        }
    }

    private void handleRegister() {
        System.out.println("Please register a new user account");
        UserCredentials credentials = consoleService.promptForCredentials();
        if (authenticationService.register(credentials)) {
            System.out.println("Registration successful. You can now login.");
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleLogin() {
        UserCredentials credentials = consoleService.promptForCredentials();
        currentUser = authenticationService.login(credentials);
        if (currentUser == null) {
            consoleService.printErrorMessage();
        }
    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                viewCurrentBalance();
            } else if (menuSelection == 2) {
                viewTransferHistory();
            } else if (menuSelection == 3) {
                viewPendingRequests();
            } else if (menuSelection == 4) {
                sendBucks();
//              transferService.listAllUsers(currentUser.getToken());
//              consoleService.promptForInt("Please enter an account id you would like to send money to");
//              selectAccountIdToSendMoney = userInput.nextLine();
//                    for (Account account : accounts)
//                        String accountIdNumber = account.getAccountId();
//              if (!selectAccountIdToSendMoney.equals(account.getAccountId())){
//                  System.out.println("enter a valid id");
//              }else
//                  System.out.println("how much money do you want to send");
//                selectAccountIdToSendMoney = userInput.nextLine();


            } else if (menuSelection == 5) {
                requestBucks();
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

    private void viewCurrentBalance() {
        // TODO Auto-generated method stub
        double balance = transferService.getBalance(currentUser.getToken());
        consoleService.displayBalance(balance);
    }

    private void viewTransferHistory() {
        // TODO Auto-generated method stub

    }

    private void viewPendingRequests() {
        // TODO Auto-generated method stub

    }

    private void sendBucks() {
        // TODO Auto-generated method stub
        Account[] accounts = transferService.listAllUsers(currentUser.getToken());
        consoleService.printUsersInAccountArray(accounts);
        int selectedUserID = consoleService.promptForInt("Please select an account ID: ");

        BigDecimal amountToSend = consoleService.promptForBigDecimal("Please enter how much money to send: ");
        double amountToSendAsDouble = amountToSend.doubleValue();

        // account from?
        Transfer newTransfer = new Transfer(-1, 1, 1, -1, selectedUserID, amountToSendAsDouble);

        Transfer resultTransfer = transferService.addTransfer(newTransfer, currentUser.getToken());
        consoleService.displayTransfer(resultTransfer);

        // .contains to string will find if account id's match up?

        // for (Account account : accounts )



       // for (Account account : accounts )
//        if (accountIdChoice.equals(account.getAccountId())) {
//            System.out.println("test");
//            consoleService.promptForBigDecimal("Please input the amount you would like to send:");
//            amountToSend = userInput.nextLine();
//        }
    }



//        // TODO Auto-generated method stub
//     //   Account[] accounts = transferService.listAllUsers(currentUser.getToken());
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBearerAuth(jwt);
//        HttpEntity<Void> request = new HttpEntity<Void>(headers);
//
//        System.out.println(transferService.listAllUsers(currentUser.getToken()));
//        consoleService.promptForInt("Please select an account ID:");
//        accountIdChoice = userInput.nextLine();
//
//
//       // for (Account account : accounts )
//        if (accountIdChoice.equals(account.getAccountId())) {
//            System.out.println("test");
//            consoleService.promptForBigDecimal("Please input the amount you would like to send:");
//            amountToSend = userInput.nextLine();
//        }
//    }


       // if (account.getAccountId(accountIdChoice) {
//if (accountIdChoice.equals(account.getAccountId())) {

//        Account[] accounts = transferService.listAllUsers(currentUser.getToken());
//        if (accounts != null){

//
//        if (sendMoney.equals(account.getAccountId())){
//            System.out.println(account.getAccountId());


    private void requestBucks() {
        // TODO Auto-generated method stub

    }


}