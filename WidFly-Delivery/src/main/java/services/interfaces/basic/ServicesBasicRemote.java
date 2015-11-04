package services.interfaces.basic;

import javax.ejb.Remote;

/**
 * @author MedAymen
 * 
 */

@Remote
public interface ServicesBasicRemote<T> extends ICrud<T> {
	T findById(String id, Class<T> type);
}
