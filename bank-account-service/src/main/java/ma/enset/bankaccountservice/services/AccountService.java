package ma.enset.bankaccountservice.services;

import ma.enset.bankaccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankaccountservice.dto.BankAccountResponceDTO;
import ma.enset.bankaccountservice.entities.BankAccount;

public interface AccountService {
    public BankAccountResponceDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
