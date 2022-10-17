package ma.enset.apmicroservices.repositories;

import ma.enset.apmicroservices.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
