package entities.embedded;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class NoteId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer customerId;
	private Integer orderId;

	public NoteId(Integer customerId, Integer orderId) {
		this.customerId = customerId;
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "NoteId [customerId=" + customerId + ", orderId=" + orderId
				+ "]";
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
}
