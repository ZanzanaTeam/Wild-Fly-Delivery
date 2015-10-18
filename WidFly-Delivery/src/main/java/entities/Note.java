package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import entities.embedded.NoteId;

@Entity
public class Note implements Serializable {

	private NoteId id;
	private Date dateNote;
	private Integer rating;
	
	private static final long serialVersionUID = 1L;

	public Note() {
	}

	public Note(Customer customer , Order order, Date dateNote, Integer rating) {

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
	
	
	

}
