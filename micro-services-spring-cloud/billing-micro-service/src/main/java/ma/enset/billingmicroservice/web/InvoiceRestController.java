package ma.enset.billingmicroservice.web;

import lombok.AllArgsConstructor;
import ma.enset.billingmicroservice.dto.InvoiceRequestDTO;
import ma.enset.billingmicroservice.dto.InvoiceResponseDTO;
import ma.enset.billingmicroservice.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
public class InvoiceRestController {
    private InvoiceService invoiceService;
    @PostMapping(path = "/invoices")
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO){
        return invoiceService.save(invoiceRequestDTO);
    }
    @GetMapping(path = "/invoices/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable String id){
        return invoiceService.getInvoiceById(id);
    }

    @GetMapping(path = "/invoicesByCustomerId/{customerId}")
    public List<InvoiceResponseDTO>  getInvoicesByCustomerId(@PathVariable String customerId){
        return invoiceService.getInvoicesByCustomerId(customerId);
    }
    @GetMapping(path = "/invoices")
    public List<InvoiceResponseDTO>  allInvoices(){
        return invoiceService.allInvoices();
    }
}
