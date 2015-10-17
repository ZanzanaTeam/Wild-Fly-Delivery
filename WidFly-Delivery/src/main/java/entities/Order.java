package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order implements Serializable {
	
	private Integer id ;
	private Date order_date ;
	private String location_delevery;
	private Boolean order_state ; 
private static final long serialVersionUID = 1L;
	
	public Order() {
		super();
		
	}
	
	
	

	public Order(Date order_date, String location_delevery, Boolean order_state) {
		super();
		this.order_date = order_date;
		this.location_delevery = location_delevery;
		this.order_state = order_state;
	}




	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public Date getOrder_date() {
		return order_date;
	}




	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}




	public String getLocation_delevery() {
		return location_delevery;
	}




	public void setLocation_delevery(String location_delevery) {
		this.location_delevery = location_delevery;
	}




	public Boolean getOrder_state() {
		return order_state;
	}




	public void setOrder_state(Boolean order_state) {
		this.order_state = order_state;
	}




	@Override
	public String toString() {
		return "Order [order_date=" + order_date + ", location_delevery="
				+ location_delevery + ", order_state=" + order_state + "]";
	}



	

}
