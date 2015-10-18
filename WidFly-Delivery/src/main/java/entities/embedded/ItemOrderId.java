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
	
	
}
