package modele;

import java.io.Serializable;
import java.util.Date;

import entities.enumeration.OrderState;

public class ModeleOrder implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private Date creation_date;
	private OrderState orderState;
	private Double total;
	private String client;

	public ModeleOrder(String id, Date creation_date, OrderState orderState,
			Double total, String client) {
		super();
		this.id = id;
		this.creation_date = creation_date;
		this.orderState = orderState;
		this.total = total;
		this.client = client;
	}

	@Override
	public String toString() {
		return "ModeleOrder [id=" + id + ", creation_date=" + creation_date
				+ ", orderState=" + orderState + ", total=" + total
				+ ", client=" + client + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

}
