package ma.enset.apmicroservices.service;

import ma.enset.apmicroservices.dto.CustomerRequestDTO;
import ma.enset.apmicroservices.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    public CustomerResponseDTO getCustomer(String id);
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    public List<CustomerResponseDTO> listCustomers();

}
