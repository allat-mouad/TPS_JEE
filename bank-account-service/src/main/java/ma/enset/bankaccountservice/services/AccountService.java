package ma.enset.bankaccountservice.services;

import ma.enset.bankaccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankaccountservice.dto.BankAccountResponceDTO;
import ma.enset.bankaccountservice.entities.BankAccount;

public interface AccountService {
    public BankAccountResponceDTO addAccount(BankAccountRequestDTO bankAccountDTO);
    public BankAccountResponceDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
    public void deleteAccount(String id);}
