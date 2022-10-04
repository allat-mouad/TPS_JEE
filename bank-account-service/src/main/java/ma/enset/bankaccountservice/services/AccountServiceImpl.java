package ma.enset.bankaccountservice.services;

import lombok.AllArgsConstructor;
import ma.enset.bankaccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankaccountservice.dto.BankAccountResponceDTO;
import ma.enset.bankaccountservice.entities.BankAccount;
import ma.enset.bankaccountservice.mappers.AccountMapper;
import ma.enset.bankaccountservice.mappers.AccountMapperImpl;
import ma.enset.bankaccountservice.mappers.AccountMapperImpli;
import ma.enset.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private AccountMapperImpli accountMapper;
    private BankAccountRepository bankAccountRepository;
    @Override
    public BankAccountResponceDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
     BankAccount bankAccount=accountMapper.fromBankAccountRequestDTO(bankAccountDTO);
     bankAccount.setId(UUID.randomUUID().toString());
     bankAccount.setCreatedAt(new Date());
     BankAccount savedBankAccount= bankAccountRepository.save(bankAccount);
     BankAccountResponceDTO bankAccountResponceDTO= accountMapper.fromBankAccount2(savedBankAccount);
     return bankAccountResponceDTO;
    }

    @Override
    public BankAccountResponceDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount1=bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
        BankAccount bankAccount=accountMapper.fromBankAccountRequestDTO(bankAccountDTO);
        bankAccount.setId(id);
        BankAccount savedBankAccount= bankAccountRepository.save(bankAccount);
        BankAccountResponceDTO bankAccountResponceDTO= accountMapper.fromBankAccount2(savedBankAccount);
        return bankAccountResponceDTO;
    }
    @Override
    public void deleteAccount(String id) {
        BankAccount bankAccount1=bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
       bankAccountRepository.deleteById(id);
    }
}
