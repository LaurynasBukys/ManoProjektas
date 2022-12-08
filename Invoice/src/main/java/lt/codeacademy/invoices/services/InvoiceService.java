package lt.codeacademy.invoices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.invoices.entities.Customer;
import lt.codeacademy.invoices.entities.Invoice;
import lt.codeacademy.invoices.repositories.CustomerRepository;
import lt.codeacademy.invoices.repositories.InvoiceRepository;



@Service
public class InvoiceService {
	@Autowired
	InvoiceRepository invoiceRepository;
	@Autowired
	CustomerRepository customerRepository;

	public List<Invoice> getInvoiceList() {
		var list = invoiceRepository.findAll();
		System.out.println(list);
		return list;
	}
	
	public Invoice addInvoice(Invoice invoice) {
		
		Customer cust = customerRepository.findById( invoice.getCustomerId().getId() ).get();
		
		invoice.setCustomerId(cust);
		
		Invoice inv = invoiceRepository.save(invoice );
		System.out.println(inv);
		return inv;
	}

	public Invoice getInvoiceById(Long id) {
		Optional<Invoice> invoice = invoiceRepository.findById( id );

		if (invoice.isEmpty()) {
			return null;
		}

		return invoice.get();
	}

	public Invoice updateInvoiceById(Long id, Invoice invoice) {

//		Item itemById = itemRepository.findById( id ).get();
//
//		itemById.setPavadinimas( item.getPavadinimas() );
//		itemById.setKodas( item.getKodas() );
//		itemById.setAprasymas( item.getAprasymas() );
//		itemById.setGrupe( item.getGrupe() );
//		itemById.setStatusas( item.getStatusas() );

		return invoiceRepository.save( invoice );
	}

	public String deleteInvoiceById(Long id) {
		boolean exists = invoiceRepository.existsById( id );

		if (exists) {
			invoiceRepository.deleteById( id );
			return "Invoice was deleted with id: " + id;
		}
		return "Invoice does not exist";
	}
}

