package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable {

	/**
	 * 
	 */
	private String id;
	private String name;
	private String icon;

	private static final long serialVersionUID = 1L;

	private List<Restaurant> restaurants;

	public Category(String id, String name, String icon) {
		this.id = id;
		this.name = name;
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", icon=" + icon + "]";
	}

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@OneToMany(mappedBy = "category")
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
}
