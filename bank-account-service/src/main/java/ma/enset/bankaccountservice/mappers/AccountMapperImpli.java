package ma.enset.bankaccountservice.mappers;

import lombok.AllArgsConstructor;
import ma.enset.bankaccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankaccountservice.dto.BankAccountResponceDTO;
import ma.enset.bankaccountservice.entities.BankAccount;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountMapperImpli implements AccountMapper {

    @Override
    public BankAccountRequestDTO fromBankAccount(BankAccount bankAccount) {
        if ( bankAccount == null ) {
            return null;
        }

        BankAccountRequestDTO.BankAccountRequestDTOBuilder bankAccountRequestDTO = BankAccountRequestDTO.builder();

        bankAccountRequestDTO.balance( bankAccount.getBalance() );
        bankAccountRequestDTO.currency( bankAccount.getCurrency() );
        bankAccountRequestDTO.type( bankAccount.getType() );

        return bankAccountRequestDTO.build();
    }

    @Override
    public BankAccountResponceDTO fromBankAccount2(BankAccount bankAccount) {
        if ( bankAccount == null ) {
            return null;
        }

        BankAccountResponceDTO.BankAccountResponceDTOBuilder bankAccountResponceDTO = BankAccountResponceDTO.builder();

        bankAccountResponceDTO.id( bankAccount.getId() );
        bankAccountResponceDTO.createdAt( bankAccount.getCreatedAt() );
        bankAccountResponceDTO.balance( bankAccount.getBalance() );
        bankAccountResponceDTO.currency( bankAccount.getCurrency() );
        bankAccountResponceDTO.type( bankAccount.getType() );

        return bankAccountResponceDTO.build();
    }

    @Override
    public BankAccount fromBankAccountRequestDTO(BankAccountRequestDTO bankAccountRequestDTO) {
        if ( bankAccountRequestDTO == null ) {
            return null;
        }

        BankAccount.BankAccountBuilder bankAccount = BankAccount.builder();

        bankAccount.balance( bankAccountRequestDTO.getBalance() );
        bankAccount.currency( bankAccountRequestDTO.getCurrency() );
        bankAccount.type( bankAccountRequestDTO.getType() );

        return bankAccount.build();
    }
}
