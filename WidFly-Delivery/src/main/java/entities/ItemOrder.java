package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import entities.embedded.ItemOrderId;

@Entity
public class ItemOrder implements Serializable {

	private ItemOrderId id;
	private double quantity = 1;

	private static final long serialVersionUID = 1L;

	public ItemOrder() {
		// TODO Auto-generated constructor stub
	}

	public ItemOrder(Menu menu, Order order, double quantity) {

		this.id = new ItemOrderId(menu.getId(), order.getId());
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ItemOrder [id=" + id + ", quantity=" + quantity + "]";
	}

	@EmbeddedId
	public ItemOrderId getId() {
		return id;
	}

	public void setId(ItemOrderId id) {
		this.id = id;
	}
	@NotNull
	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	
	

}
