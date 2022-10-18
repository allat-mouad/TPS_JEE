package ma.enset.apmicroservices.web;

import lombok.AllArgsConstructor;
import ma.enset.apmicroservices.dto.CustomerRequestDTO;
import ma.enset.apmicroservices.dto.CustomerResponseDTO;
import ma.enset.apmicroservices.entities.Customer;
import ma.enset.apmicroservices.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
public class CustomerRESTController {
    private CustomerService customerService;
    @GetMapping(path = "/customers")
    public List<CustomerResponseDTO> cutomers(){
        return customerService.listCustomers();
    }
    @PostMapping(path ="/customers")
    public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO)
    {
        customerRequestDTO.setId(UUID.randomUUID().toString());
        return customerService.save(customerRequestDTO);
    }
    @GetMapping(path = "/customers/{id}")
    public CustomerResponseDTO getCutomers(@PathVariable String id){
        return customerService.getCustomer(id);
    }

}
