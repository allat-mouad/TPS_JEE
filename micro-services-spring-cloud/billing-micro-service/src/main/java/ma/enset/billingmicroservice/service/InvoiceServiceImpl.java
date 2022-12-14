package ma.enset.billingmicroservice.service;

import lombok.AllArgsConstructor;
import ma.enset.billingmicroservice.dto.InvoiceRequestDTO;
import ma.enset.billingmicroservice.dto.InvoiceResponseDTO;
import ma.enset.billingmicroservice.entities.Customer;
import ma.enset.billingmicroservice.entities.Invoice;
import ma.enset.billingmicroservice.exceptions.CustomerNotFoundException;
import ma.enset.billingmicroservice.mappers.InvoiceMapper;
import ma.enset.billingmicroservice.openfeign.CustomerRestClient;
import ma.enset.billingmicroservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestClient customerRestClient;
    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
        Customer customer=null;
        try {
             customer = customerRestClient.getCustomer(invoiceRequestDTO.getCustomerId());
        }catch (CustomerNotFoundException e){
            throw  new CustomerNotFoundException(invoiceRequestDTO.getCustomerId());
        }

        Invoice invoice= invoiceMapper.invoiceRequestDTOToInvoice(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());

        Invoice savedInvoice = invoiceRepository.save(invoice);
        savedInvoice.setCustomer(customer);
        return invoiceMapper.invoiceToInvoiceResponseDTO(savedInvoice);
    }

    @Override
    public InvoiceResponseDTO update(InvoiceRequestDTO invoiceRequestDTO) {
        return null;
    }

    @Override
    public InvoiceResponseDTO getInvoiceById(String id) {
        Invoice invoice= invoiceRepository.findById(id).get();
        Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
        invoice.setCustomer(customer);
        return invoiceMapper.invoiceToInvoiceResponseDTO(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> allInvoices() {
        List<Invoice> invoiceList= invoiceRepository.findAll();
        for (Invoice invoice:invoiceList){
            Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
            invoice.setCustomer(customer);
        }
        return invoiceList.stream().map(invoice -> invoiceMapper.invoiceToInvoiceResponseDTO(invoice))
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponseDTO> getInvoicesByCustomerId(String id) {
        List<Invoice> invoiceList= invoiceRepository.findByCustomerId(id);
        for (Invoice invoice:invoiceList){
            Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
            invoice.setCustomer(customer);
        }
        return invoiceList.stream().map(invoice -> invoiceMapper.invoiceToInvoiceResponseDTO(invoice))
                .collect(Collectors.toList());
    }
}
