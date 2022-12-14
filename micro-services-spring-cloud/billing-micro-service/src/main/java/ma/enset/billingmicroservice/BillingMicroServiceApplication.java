package ma.enset.billingmicroservice;

import ma.enset.billingmicroservice.dto.InvoiceRequestDTO;
import ma.enset.billingmicroservice.service.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
@EnableFeignClients
public class BillingMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingMicroServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(InvoiceService invoiceService){
        return  args -> {
          invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(98000),"C01"));
          invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(32800),"C02"));
          invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(12800),"C03"));
        };
    }
}
