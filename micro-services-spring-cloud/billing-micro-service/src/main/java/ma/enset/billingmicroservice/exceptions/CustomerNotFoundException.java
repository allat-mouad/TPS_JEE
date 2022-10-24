package ma.enset.billingmicroservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Bank Account not found")
public class CustomerNotFoundException extends RuntimeException  {
    public CustomerNotFoundException(String customer_not_found) {
            super(
                    String.format("Cannot find customer with id : %s", customer_not_found)
            );
        }

}
