package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Menu implements Serializable {

	private Integer id;
	private String name;
	private Double price;
	private String details;
	private static final long serialVersionUID = 1L;

	private List<ItemOrder> itemOrders;
	private Restaurant complaint;

	public Menu() {
		super();

	}

	public Menu(String name, Double price, String details) {
		super();
		this.name = name;
		this.price = price;
		this.details = details;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", price=" + price
				+ ", details=" + details + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@OneToMany(mappedBy = "menu")
	public List<ItemOrder> getItemOrders() {
		return itemOrders;
	}

	public void setItemOrders(List<ItemOrder> itemOrders) {
		this.itemOrders = itemOrders;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	public Restaurant getComplaint() {
		return complaint;
	}

	public void setComplaint(Restaurant complaint) {
		this.complaint = complaint;
	}

}
