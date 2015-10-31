package services.interfaces.basic;

import javax.ejb.Local;

/**
 * @author MedAymen
 * 
 */

@Local
public interface ServicesBasicLocal<T> extends ICrud<T> {

	T findById(String id , Class<T> type);
}
