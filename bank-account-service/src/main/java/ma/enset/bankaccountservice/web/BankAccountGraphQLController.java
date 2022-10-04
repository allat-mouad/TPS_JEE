package ma.enset.bankaccountservice.web;

import lombok.AllArgsConstructor;
import ma.enset.bankaccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankaccountservice.dto.BankAccountResponceDTO;
import ma.enset.bankaccountservice.entities.BankAccount;
import ma.enset.bankaccountservice.repositories.BankAccountRepository;
import ma.enset.bankaccountservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
@AllArgsConstructor
public class BankAccountGraphQLController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }

    @MutationMapping
    public BankAccountResponceDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
       return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponceDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount) {
        return accountService.updateAccount(id,bankAccount);
    }
    @MutationMapping
    public void deleteAccount(@Argument String id) {
        accountService.deleteAccount(id);
    }


}
