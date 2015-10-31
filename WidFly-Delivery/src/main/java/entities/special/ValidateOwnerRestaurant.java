package entities.special;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import entities.Owner;
import entities.Restaurant;

@Entity
public class ValidateOwnerRestaurant {

	
	private Integer id;
	private String code;
	private Date CreationDate;
	private Date ValidateDate;
	
	private Restaurant restaurant;
	private Owner owner;
	
	public ValidateOwnerRestaurant() {
		// TODO Auto-generated constructor stub
	}

	public ValidateOwnerRestaurant(String code, Date creationDate,
			Date validateDate, Restaurant restaurant, Owner owner) {
		this.code = code;
		CreationDate = creationDate;
		ValidateDate = validateDate;
		this.restaurant = restaurant;
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "ValidateOwnerRestaurant [id=" + id + ", code=" + code
				+ ", CreationDate=" + CreationDate + ", ValidateDate="
				+ ValidateDate + ", restaurant=" + restaurant + ", owner="
				+ owner + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}

	public Date getValidateDate() {
		return ValidateDate;
	}

	public void setValidateDate(Date validateDate) {
		ValidateDate = validateDate;
	}

	@ManyToOne
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@ManyToOne
	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	
}
