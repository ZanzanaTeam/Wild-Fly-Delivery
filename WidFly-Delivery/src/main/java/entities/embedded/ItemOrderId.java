package entities.embedded;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ItemOrderId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer menuId;
	private Integer orderId;
	public ItemOrderId() {
		// TODO Auto-generated constructor stub
	}
	
	public ItemOrderId(Integer menuId, Integer orderId) {
		this.menuId = menuId;
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "ItemOrderId [menuId=" + menuId + ", orderId=" + orderId + "]";
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuId == null) ? 0 : menuId.hashCode());
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
		ItemOrderId other = (ItemOrderId) obj;
		if (menuId == null) {
			if (other.menuId != null)
				return false;
		} else if (!menuId.equals(other.menuId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}
	
	
}
