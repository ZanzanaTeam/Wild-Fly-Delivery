package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment implements Serializable {
	
	private Integer id ;
	private Boolean payement_type ;
	private Double amount ; 

	private static final long serialVersionUID = 1L;
		
		public Payment() {
			super();
			
		}
		
		

		public Payment(Boolean payement_type, Double amount) {
			super();
			this.payement_type = payement_type;
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
		
		
		public Boolean getPayement_type() {
			return payement_type;
		}



		public void setPayement_type(Boolean payement_type) {
			this.payement_type = payement_type;
		}



		public Double getAmount() {
			return amount;
		}



		public void setAmount(Double amount) {
			this.amount = amount;
		}



		@Override
		public String toString() {
			return "Payment [payement_type=" + payement_type + ", amount="
					+ amount + "]";
		}



		



}
