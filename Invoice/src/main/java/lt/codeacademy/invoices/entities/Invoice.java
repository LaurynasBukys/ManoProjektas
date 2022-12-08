package lt.codeacademy.invoices.entities;

import java.time.LocalDate;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String invoiceNumber;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="date")
	private LocalDate myDate;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="customer_id", nullable=false)
	private Customer customerId;
	
	@OneToMany(mappedBy = "invoice")
	private List<InvoiceItem> invoiceItems;

	
	
	
}
