package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MenuSpecification implements Serializable {
	public MenuSpecification() {
		// TODO Auto-generated constructor stub
	}

	private Integer id;
	private String comment;

	private static final long serialVersionUID = 1L;

	private ItemOrder itemOrder;

	public MenuSpecification(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "MenuSpecifications [id=" + id + ", comment=" + comment + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@ManyToOne
	public ItemOrder getItemOrder() {
		return itemOrder;
	}

	public void setItemOrder(ItemOrder itemOrder) {
		this.itemOrder = itemOrder;
	}

}
