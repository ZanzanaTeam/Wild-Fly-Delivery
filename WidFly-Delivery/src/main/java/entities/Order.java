package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import entities.enumeration.LivraisonType;
import entities.enumeration.OrderState;

@Entity
@Table(name="T_Order")
public class Order implements Serializable {

	private Integer id;
	private Date orderDate;
	private String locationDelevery;
	private OrderState orderState;
	private LivraisonType livraisonType;
	private static final long serialVersionUID = 1L;

	public Order() {

	}

	public Order(Date orderDate, String locationDelevery,
			OrderState orderState, LivraisonType livraisonType) {
		this.orderDate = orderDate;
		this.locationDelevery = locationDelevery;
		this.orderState = orderState;
		this.livraisonType = livraisonType;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate
				+ ", locationDelevery=" + locationDelevery + ", orderState="
				+ orderState + ", livraisonType=" + livraisonType + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getLocationDelevery() {
		return locationDelevery;
	}

	public void setLocationDelevery(String locationDelevery) {
		this.locationDelevery = locationDelevery;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public LivraisonType getLivraisonType() {
		return livraisonType;
	}

	public void setLivraisonType(LivraisonType livraisonType) {
		this.livraisonType = livraisonType;
	}


}
