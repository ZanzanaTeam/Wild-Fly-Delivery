package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DefaultValue;

import entities.embedded.ItemOrderId;

@Entity
public class ItemOrder implements Serializable {

	private ItemOrderId id;
	private double qte = 1;

	private static final long serialVersionUID = 1L;

	public ItemOrder() {
		// TODO Auto-generated constructor stub
	}

	public ItemOrder(Menu menu, Order order, double qte) {

		this.id = new ItemOrderId(menu.getId(), order.getId());
		this.qte = qte;
	}

	@Override
	public String toString() {
		return "ItemOrder [id=" + id + ", qte=" + qte + "]";
	}

	@EmbeddedId
	public ItemOrderId getId() {
		return id;
	}

	public void setId(ItemOrderId id) {
		this.id = id;
	}

	@NotNull
	@DefaultValue(value = "1")
	public double getQte() {
		return qte;
	}

	public void setQte(double qte) {
		this.qte = qte;
	}

}
