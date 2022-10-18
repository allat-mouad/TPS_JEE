package ma.enset.billingmicroservice.service;

import ma.enset.billingmicroservice.dto.InvoiceRequestDTO;
import ma.enset.billingmicroservice.dto.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);
    public InvoiceResponseDTO update(InvoiceRequestDTO invoiceRequestDTO);
    public InvoiceResponseDTO getInvoiceById(String invoiceId);
    public List<InvoiceResponseDTO> getInvoicesByCustomerId(String customerId);

}
