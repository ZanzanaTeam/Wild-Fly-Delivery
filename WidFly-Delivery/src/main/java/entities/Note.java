package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import entities.embedded.NoteId;

@Entity
public class Note implements Serializable {

	private NoteId id;
	private Date dateNote;
	private Integer rating;

	private static final long serialVersionUID = 1L;
	
	private Order order;
	private Customer customer;
	
	public Note() {
	}

	public Note(Customer customer, Order order, Date dateNote, Integer rating) {

		this.id = new NoteId(customer.getId(), order.getId());
		this.dateNote = dateNote;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", dateNote=" + dateNote + ", rating="
				+ rating + "]";
	}

	@EmbeddedId
	public NoteId getId() {
		return id;
	}

	public void setId(NoteId id) {
		this.id = id;
	}

	public Date getDateNote() {
		return dateNote;
	}

	public void setDateNote(Date dateNote) {
		this.dateNote = dateNote;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateNote == null) ? 0 : dateNote.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (dateNote == null) {
			if (other.dateNote != null)
				return false;
		} else if (!dateNote.equals(other.dateNote))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		return true;
	}

	@ManyToOne
	@JoinColumn(name="orderId" , referencedColumnName="id" , updatable =false , insertable = false)
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	@ManyToOne
	@JoinColumn(name="customerId" , referencedColumnName="id" , updatable =false, insertable= false)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
