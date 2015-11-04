package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import entities.embedded.ItemOrderId;

@Entity
public class ItemOrder implements Serializable {

	private ItemOrderId id;
	private double quantity = 1;

	private static final long serialVersionUID = 1L;

	private Menu menu;
	private Order order;
	private List<MenuSpecification> menuSpecifications;
	
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

	@ManyToOne
	@JoinColumn(name="menuId" , referencedColumnName="id" , updatable =false , insertable = false)
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="orderId" , referencedColumnName="id" , updatable=false, insertable = false)
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@OneToMany(mappedBy="itemOrder")
	public List<MenuSpecification> getMenuSpecifications() {
		return menuSpecifications;
	}

	public void setMenuSpecifications(List<MenuSpecification> menuSpecifications) {
		this.menuSpecifications = menuSpecifications;
	}

	
	

}
