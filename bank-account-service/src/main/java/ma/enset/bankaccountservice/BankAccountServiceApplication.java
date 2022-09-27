package ma.enset.bankaccountservice;

import lombok.Builder;
import ma.enset.bankaccountservice.enums.AccountType;
import ma.enset.bankaccountservice.entities.BankAccount;
import ma.enset.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;


@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }
    @Bean

    CommandLineRunner start(BankAccountRepository bankAccountRepository) {
        return args -> {
            for(int i=0;i<10;i++) {
                BankAccount bankAccount = BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Math.random()>0.5? AccountType.SAVING_ACCOUNT:AccountType.CURREENT_ACCOUNT)
                        .balance(1000+Math.random()*9000)
                        .currency("MAD")
                        .createdAt(new Date())
                        .build();
                bankAccountRepository.save(bankAccount);
            }
        };

}
}
