package ma.enset.apmicroservices.service;

import lombok.AllArgsConstructor;
import ma.enset.apmicroservices.dto.CustomerRequestDTO;
import ma.enset.apmicroservices.dto.CustomerResponseDTO;
import ma.enset.apmicroservices.entities.Customer;
import ma.enset.apmicroservices.mappers.CustomerMapper;
import ma.enset.apmicroservices.mappers.CustomerMapperImpli;
import ma.enset.apmicroservices.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapperImpli customerMapper;



    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
       /* Customer customer= new Customer();
        customer.setId(customerRequestDTO.getId());
        customer.setEmail(customerRequestDTO.getEmail());
        customer.setName(customerRequestDTO.getName());*/
        Customer customer =customerMapper.customerRequestDTOToCustomer(customerRequestDTO);

        Customer savedCustomer= customerRepository.save(customer);

       /* CustomerResponseDTO customerResponseDTO=new CustomerResponseDTO();
        customerResponseDTO.setId(savedCustomer.getId());
        customerResponseDTO.setName(savedCustomer.getName());
        customerResponseDTO.setEmail(savedCustomer.getEmail());*/
        CustomerResponseDTO customerResponseDTO=customerMapper.customerToCustomerResponseDTO(customer);
        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer=customerRepository.findById(id).get();
        CustomerResponseDTO customerResponseDTO=customerMapper.customerToCustomerResponseDTO(customer);
        return customerResponseDTO;

    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer= customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        Customer updatedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(updatedCustomer);

    }

    @Override
    public List<CustomerResponseDTO> listCustomers()
    {
        List<Customer> customerList=customerRepository.findAll();
        List<CustomerResponseDTO> responseDTOList=customerList.stream()
                .map(cust->customerMapper.customerToCustomerResponseDTO(cust))
                .collect(Collectors.toList());
        return responseDTOList;
    }
}
