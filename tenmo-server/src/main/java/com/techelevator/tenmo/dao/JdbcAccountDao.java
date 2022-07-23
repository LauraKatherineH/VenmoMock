package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.Exceptions.AccountNotFoundException;
import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAccountDao implements AccountDao {

    private final JdbcTemplate jdbcTemplate;

    // private static List <Account> accounts = new ArrayList<>();
    private List<Account> accounts;
    private AccountDao accountDao;
    private Account account;
    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }






    @Override
    public Account getAccount(long accountId) throws AccountNotFoundException {
        Account account = null;
        String sql = "SELECT account_id, user_id, balance, FROM account WHERE account_id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
        if (results.next()) {
            account = mapRowToAccount(results);
        }
        return account;
    }

    @Override
    public Account getAccountByUserId(long userID) throws AccountNotFoundException {
        Account account = null;
        String sql = "SELECT account_id, user_id, balance FROM account WHERE user_id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userID);
        if (results.next()) {
            account = mapRowToAccount(results);
        }
        return account;
    }


//    @Override
//    public List<Account> list() {


        @Override
        public List<Account> list() {
            List<Account> accounts = new ArrayList<>();
            String sql = "SELECT account_id, username FROM account JOIN tenmo_user USING (user_id);";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()) {
                Account account = mapRowToDisplay(results);
                accounts.add(account);
            }
            return accounts;
        }


    //// List<Reservation> hotelReservations = new ArrayList<>();
////        for (Reservation r : reservations) {
////            if (r.getHotelID() == hotelID) {
////                hotelReservations.add(r);
//        @Override
        public Account getBalance ( long accountId){
            Account account = null;
            String sql = "SELECT account_id,user_id,balance FROM account WHERE account_id=?";
            System.out.println("accountId:" + accountId);
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
            if (results.next()) {
                account = mapRowToAccount(results);
            }
            return account;
        }


//    @Override
//    public Account updateBalance(Double balance, ) throws BalanceNotFoundException {\
//        Account account = null;
//        String sql = "SELECT "
//
//        return null;
//
//    }

        private Account mapRowToAccount (SqlRowSet result){
            Account account = new Account();
            account.setAccountId(result.getLong("account_id"));
            account.setUserId(result.getLong("user_id"));
            account.setBalance(result.getDouble("balance"));
            return account;
        }

        private Account mapRowToDisplay (SqlRowSet rs){
            Account accounts = new Account();
            accounts.setAccountId(rs.getLong("account_id"));
            accounts.setUserName(rs.getString("username"));
            return accounts;
        }



    }





