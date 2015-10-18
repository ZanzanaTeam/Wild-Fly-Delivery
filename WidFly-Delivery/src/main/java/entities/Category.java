package entities;

public class Category {

	private String id;
	private String name;
	private String icon;
	public Category(String id, String name, String icon) {
		this.id = id;
		this.name = name;
		this.icon = icon;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", icon=" + icon + "]";
	}
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
	
	
}
