package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Category;

@Local
public interface FoursquareServiceLocal {
	
	List<Category> findAllCategory();
		
	
}
