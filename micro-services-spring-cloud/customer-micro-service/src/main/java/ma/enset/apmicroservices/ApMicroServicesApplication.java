package ma.enset.apmicroservices;

import ma.enset.apmicroservices.dto.CustomerRequestDTO;
import ma.enset.apmicroservices.entities.Customer;
import ma.enset.apmicroservices.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ApMicroServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApMicroServicesApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerService customerService){
        return  args -> {
            Stream.of("Amine", "Karim", "Omar").forEach(c -> {
                CustomerRequestDTO customer = new CustomerRequestDTO();
                customer.setName(c);
                customer.setEmail(c+"@gmail.com");
                customer.setId(UUID.randomUUID().toString());
                customerService.save(customer);
            });
        };
    }
}
