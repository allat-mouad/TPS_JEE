package ma.enset.apmicroservices.mappers;

import ma.enset.apmicroservices.dto.CustomerRequestDTO;
import ma.enset.apmicroservices.dto.CustomerResponseDTO;
import ma.enset.apmicroservices.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapperImpli implements CustomerMapper {
    @Override
    public CustomerResponseDTO customerToCustomerResponseDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();

        customerResponseDTO.setId( customer.getId() );
        customerResponseDTO.setName( customer.getName() );
        customerResponseDTO.setEmail( customer.getEmail() );

        return customerResponseDTO;
    }

    @Override
    public CustomerRequestDTO customerToCustomerRequestDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();

        customerRequestDTO.setId( customer.getId() );
        customerRequestDTO.setName( customer.getName() );
        customerRequestDTO.setEmail( customer.getEmail() );

        return customerRequestDTO;
    }

    @Override
    public Customer customerResponseDTOToCustomer(CustomerResponseDTO customerResponseDTO) {
        if ( customerResponseDTO == null ) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();

        customer.id( customerResponseDTO.getId() );
        customer.name( customerResponseDTO.getName() );
        customer.email( customerResponseDTO.getEmail() );

        return customer.build();
    }

    @Override
    public Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO) {
        if ( customerRequestDTO == null ) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();

        customer.id( customerRequestDTO.getId() );
        customer.name( customerRequestDTO.getName() );
        customer.email( customerRequestDTO.getEmail() );

        return customer.build();
    }
}
