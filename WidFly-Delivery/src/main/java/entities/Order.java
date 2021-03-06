package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import entities.embedded.Address;
import entities.enumeration.DeliveryType;
import entities.enumeration.OrderState;

@Entity
@Table(name = "T_Order")
public class Order implements Serializable {

	private String id;
	private Date orderDate;
	private Address locationDelivery;
	private OrderState orderState;
	private DeliveryType livraisonType;
	private static final long serialVersionUID = 1L;

	private Customer customer;
	private List<Note> notes;

	private List<Payment> payments;
	private List<ItemOrder> itemOrders;
	private Restaurant restaurant;

	public Order() {

	}


	public Order(String id, Address locationDelivery,
			OrderState orderState, DeliveryType livraisonType) {
		super();
		this.id = id;
		this.orderDate = new Date();
		this.locationDelivery = locationDelivery;
		this.orderState = orderState;
		this.livraisonType = livraisonType;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate
				+ ", locationDelivery=" + locationDelivery + ", orderState="
				+ orderState + ", livraisonType=" + livraisonType + "]";
	}

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public DeliveryType getLivraisonType() {
		return livraisonType;
	}

	public void setLivraisonType(DeliveryType livraisonType) {
		this.livraisonType = livraisonType;
	}

	public Address getLocationDelivery() {
		return locationDelivery;
	}

	public void setLocationDelivery(Address locationDelivery) {
		this.locationDelivery = locationDelivery;
	}

	@ManyToOne
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@OneToMany(mappedBy = "order")
	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	@OneToMany(mappedBy = "order")
	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	@OneToMany(mappedBy = "order")
	public List<ItemOrder> getItemOrders() {
		return itemOrders;
	}

	public void setItemOrders(List<ItemOrder> itemOrders) {
		this.itemOrders = itemOrders;
	}

	@ManyToOne
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
