package ma.enset.apmicroservices.mappers;

import ma.enset.apmicroservices.dto.CustomerRequestDTO;
import ma.enset.apmicroservices.dto.CustomerResponseDTO;
import ma.enset.apmicroservices.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE= Mappers.getMapper(CustomerMapper.class);
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    CustomerRequestDTO customerToCustomerRequestDTO(Customer customer);
    Customer customerResponseDTOToCustomer(CustomerResponseDTO customerResponseDTO);
    Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);

}
