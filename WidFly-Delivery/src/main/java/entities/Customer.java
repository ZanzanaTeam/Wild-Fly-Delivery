package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer implements Serializable {

	private Integer id;
	private String full_name;
	private static final long serialVersionUID = 1L;

	public Customer() {

	}

	public Customer(String full_name) {
		super();
		this.full_name = full_name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String fullname) {
		this.full_name = fullname;
	}

	@Override
	public String toString() {
		return "Customer [fullname=" + full_name + "]";
	}

}
