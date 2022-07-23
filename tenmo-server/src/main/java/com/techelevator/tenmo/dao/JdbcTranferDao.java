package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.Exceptions.TransferNotCompleteException;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTranferDao implements TransferDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTranferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Transfer> listAllTransfers() {
            List<Transfer> transfers = new ArrayList<>();
            String sql = "SELECT transfer_id, username FROM transfer;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()) {
                Transfer transfer = mapRowtoTransfer(results);
                transfers.add(transfer);
            }
            return transfers;
        }

    @Override
    public Transfer createTransfer(Transfer transfer, long transferId) throws TransferNotCompleteException {
        String sql = "INSERT INTO transfer (transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, transfer.getTransferId(), transfer.getTransferType(), transfer.getTransferStatusId(), transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getAmount());
        return transfer;
    }

    @Override
    public Transfer getTransfer(long transfer_id) throws TransferNotCompleteException{
        Transfer transfer = null;
        String sql = "SELECT * FROM TRANSFER WHERE transfer_id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transfer);
        if (results.next()){
            transfer = mapRowtoTransfer(results);

        }
        return transfer;
    }


    @Override
    public Transfer getTransferAmount(Double amount) throws TransferNotCompleteException {
        Transfer transfer = null;
        String sql = "SELECT * FROM transfer WHERE amount=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, amount);
        if (results.next()) {
            transfer = mapRowtoTransfer(results);
        }
        return transfer;
    }


    @Override
    public Transfer getTransferId(long transfer_type_id) throws TransferNotCompleteException {
        Transfer transfer = null;
        String sql = "SELECT * FROM transfer WHERE transfer_id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transfer_type_id);
        if (results.next()) {
            transfer = mapRowtoTransfer(results);
        }
        return transfer;
    }

    @Override
    public Transfer getTransferType(long transfer_type) throws TransferNotCompleteException {
        return null;
    }

    @Override
    public Transfer getTransferStatusId(long transfer_status_id) throws TransferNotCompleteException {
        return null;
    }

    @Override
    public Transfer getAccountFrom(long account_from) throws TransferNotCompleteException {
        // join tables here?
        Transfer transfer = null;
        String sql = "SELECT * FROM transfer join account on account.account_id = transfer.account_from WHERE account_id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, account_from);
        if (results.next()) {
            transfer = mapRowtoTransfer(results);
        }

        return transfer;
    }

    @Override
    public Transfer getAccountTo(long account_to) throws TransferNotCompleteException {
        Transfer transfer = null;
        String sql = "SELECT * FROM transfer join account on account.account_id = transfer.account_from WHERE account_id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, account_to);
        if (results.next()) {
            transfer = mapRowtoTransfer(results);
        }

        return transfer;
    }


    private Transfer mapRowtoTransfer(SqlRowSet result) {
        Transfer transfer = new Transfer();

        transfer.setTransferId(result.getLong("transfer_id"));
        transfer.setTransferType(result.getLong("transfer_type_id"));
        transfer.setTransferStatusId(result.getLong("transfer_status_id"));
        transfer.setAccountFrom(result.getLong("account_from"));
        transfer.setAccountTo(result.getLong("account_to"));
        transfer.setAmount(result.getDouble("amount"));

        return transfer;
    }


}
