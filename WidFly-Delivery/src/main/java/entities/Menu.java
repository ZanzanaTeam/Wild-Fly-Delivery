package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu implements Serializable {
	
	private Integer id ;
	private String name ;
	private Double price ;
	private String details ; 
private static final long serialVersionUID = 1L;
	
	public Menu() {
		super();
		
	}
	

	public Menu(String name, Double price, String details) {
		super();
		this.name = name;
		this.price = price;
		this.details = details;
	}


	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


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
	
	

}
