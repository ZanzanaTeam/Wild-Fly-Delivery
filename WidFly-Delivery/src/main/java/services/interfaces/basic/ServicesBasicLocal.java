package services.interfaces.basic;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

/**
 * @author MedAymen
 * 
 */

@Local
public interface ServicesBasicLocal<T> extends ICrud<T> {

	List<T> findBy(Map where, Class<T> type);

	List<T> findBy(Map where, Map orderby, Class<T> type);

	T findById(String id, Class<T> type);

	List<T> findBy(Map where, Map orderby, int limit, Class<T> type);

	T findOneBy(Map where, Class<T> type);

}
