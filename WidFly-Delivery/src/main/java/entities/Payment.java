package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import entities.enumeration.PayementType;

@Entity
public class Payment implements Serializable {
	
	private Integer id ;
	private PayementType payementType ;
	private Double amount ;
	private Date payementDate;

	private static final long serialVersionUID = 1L;
		
		public Payment() {
			super();
			
		}
		
		

		public Payment(PayementType payementType, Double amount) {
			super();
			this.payementType = payementType;
			this.amount = amount;
		}



		@Id  
		@GeneratedValue(strategy=GenerationType.IDENTITY)

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
		
		
		public PayementType getPayement_type() {
			return payementType;
		}



		public void setPayement_type(PayementType payementType) {
			this.payementType = payementType;
		}



		public Double getAmount() {
			return amount;
		}



		public void setAmount(Double amount) {
			this.amount = amount;
		}



		@Override
		public String toString() {
			return "Payment [payementType=" + payementType + ", amount="
					+ amount + "]";
		}



		public Date getPayementDate() {
			return payementDate;
		}



		public void setPayementDate(Date payementDate) {
			this.payementDate = payementDate;
		}



		



}
