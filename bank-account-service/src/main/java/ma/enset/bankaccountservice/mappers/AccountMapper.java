package ma.enset.bankaccountservice.mappers;

import ma.enset.bankaccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankaccountservice.dto.BankAccountResponceDTO;
import ma.enset.bankaccountservice.entities.BankAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE= Mappers.getMapper(AccountMapper.class);
    BankAccountRequestDTO fromBankAccount(BankAccount bankAccount);
    BankAccountResponceDTO fromBankAccount2(BankAccount bankAccount);
    BankAccount fromBankAccountRequestDTO(BankAccountRequestDTO bankAccountRequestDTO);
}
