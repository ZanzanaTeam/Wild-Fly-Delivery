package services.implementation.basic;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.interfaces.basic.ServicesBasicLocal;
import services.interfaces.basic.ServicesBasicRemote;

/**
 * @author MedAymen
 * 
 */

@Stateless
public class ServicesBasic<T> implements ServicesBasicLocal<T>,
		ServicesBasicRemote<T> {

	@PersistenceContext
	EntityManager entityManager;

	public ServicesBasic() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean update(T t) {
		try {
			entityManager.merge(t);
			return true;
		} catch (Exception ee) {
			return false;
		}
	}

	@Override
	public Boolean delete(T t) {
		try {
			entityManager.remove(t);
			return true;
		} catch (Exception ee) {
			return false;
		}
	}

	@Override
	public T findById(Integer id, Class<T> type) {
		return entityManager.find(type, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> type) {
		List<T> lists = null;
		try {
			String jpql = "select e from " + type.getSimpleName() + " e";

			lists = entityManager.createQuery(jpql).getResultList();

		} catch (Exception ee) {

		}

		return lists;
	}

	@Override
	public Boolean add(T t) {
		try {

			entityManager.merge(t);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
