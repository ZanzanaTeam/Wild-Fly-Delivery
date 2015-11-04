package entities.embedded;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class NoteId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer customerId;
	private String orderId;

	public NoteId() {
		// TODO Auto-generated constructor stub
	}

	public NoteId(Integer customerId, String orderId) {
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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoteId other = (NoteId) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

}
