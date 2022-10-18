package ma.enset.billingmicroservice.mappers;
import ma.enset.billingmicroservice.dto.InvoiceRequestDTO;
import ma.enset.billingmicroservice.dto.InvoiceResponseDTO;
import ma.enset.billingmicroservice.entities.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    InvoiceMapper INSTANCE= Mappers.getMapper(InvoiceMapper.class);
    InvoiceResponseDTO invoiceToInvoiceResponseDTO(Invoice invoice);
    InvoiceRequestDTO invoiceToInvoiceRequestDTO(Invoice invoice);
    Invoice invoiceResponseDTOToInvoice(InvoiceResponseDTO invoiceResponseDTO);
    Invoice invoiceRequestDTOToInvoice(InvoiceRequestDTO invoiceRequestDTO);

}
