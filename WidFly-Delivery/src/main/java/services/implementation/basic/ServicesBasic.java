package services.implementation.basic;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.basic.ServicesBasicLocal;
import services.interfaces.basic.ServicesBasicRemote;

/**
 * @author MedAymen
 * 
 */

@Stateless
public class ServicesBasic<T> implements ServicesBasicRemote<T>,ServicesBasicLocal<T> {

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

	@Override
	public T findById(String id, Class<T> type) {
		return entityManager.find(type, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T findOneBy(Map where,  Class<T> type) {
		T object = null;
		try {
			String jpql = "select e from " + type.getSimpleName() + " e";
			Query query = entityManager.createQuery(jpql);
			if ( where.size() >0 ){
				String condition = "where ";
				Iterator iterator = where.keySet().iterator();

				  Object key   = iterator.next();
				  Object value = where.get(key);
				condition += key +" =:"+ key; 
				while(iterator.hasNext()){
				  key   = iterator.next();
				  value = where.get(key);
				  condition += "and "+ key +" =:"+ key;
				}
				query = entityManager.createQuery(jpql);
				
				for(Object key2 : where.keySet()) {
					Object value2 = where.get(key2);
					query.setParameter((String) key2, value2);
				}
			}
			
			object = (T) query.getSingleResult();
			

		} catch (Exception ee) {

		}

		return object;
	}

	@Override
	public List<T> findBy(Map where, Map orderby, int limit, Class<T> type) {
		
		List<T> lists = null;
		
		try {
			String jpql = "select e from " + type.getSimpleName() + " e";
			String condition = "";
			String order = "";
			Query query = entityManager.createQuery(jpql);
			
			if ( where.size() >0 ){
				condition = "where ";
				Iterator iterator = where.keySet().iterator();

				  Object key   = iterator.next();
				  Object value = where.get(key);
				condition += key +" =:"+ key; 
				while(iterator.hasNext()){
				  key   = iterator.next();
				  value = where.get(key);
				  condition += "and "+ key +" =:"+ key;
				}
				jpql += condition;
				query = entityManager.createQuery(jpql);
				
				for(Object key2 : where.keySet()) {
					Object value2 = where.get(key2);
					query.setParameter((String) key2, value2);
				}
			}
			if ( orderby.size() >0 ){
				order = "Order By";
				Iterator iterator = orderby.keySet().iterator();
				while(iterator.hasNext()){
				  Object key   = iterator.next();
				  Object value = orderby.get(key);
				  order += (String) key + " " +  (String) value ;
				}

				jpql += order;
				
				query = entityManager.createQuery(jpql);
				if (limit>0){
					query.setMaxResults(limit);
				}
				
			}
			
			lists = entityManager.createQuery(jpql).getResultList();

		} catch (Exception ee) {

		}

		return lists;
	}

	@Override
	public List<T> findBy(Map where, Class<T> type) {

		List<T> lists = null;
		
		try {
			String jpql = "select e from " + type.getSimpleName() + " e";
			String condition = "";
			String order = "";

			Query query = entityManager.createQuery(jpql);
			if ( where.size() >0 ){
				condition = "where ";
				Iterator iterator = where.keySet().iterator();

				  Object key   = iterator.next();
				  Object value = where.get(key);
				condition += key +" =:"+ key; 
				while(iterator.hasNext()){
				  key   = iterator.next();
				  value = where.get(key);
				  condition += "and "+ key +" =:"+ key;
				}
				
				jpql += condition;
				query = entityManager.createQuery(jpql);
				
				for(Object key2 : where.keySet()) {
					Object value2 = where.get(key2);
					query.setParameter((String) key2, value2);
				}
			}
			
			lists = entityManager.createQuery(jpql).getResultList();

		} catch (Exception ee) {

		}

		return lists;
	}

	@Override
	public List<T> findBy(Map where, Map orderby, Class<T> type) {

		List<T> lists = null;
		
		try {
			String jpql = "select e from " + type.getSimpleName() + " e";
			String condition = "";
			String order = "";
			Query query = entityManager.createQuery(jpql);
			
			if ( where.size() >0 ){
				condition = "where ";
				Iterator iterator = where.keySet().iterator();

				  Object key   = iterator.next();
				  Object value = where.get(key);
				condition += key +" =:"+ key; 
				while(iterator.hasNext()){
				  key   = iterator.next();
				  value = where.get(key);
				  condition += "and "+ key +" =:"+ key;
				}
				jpql += condition;
				query = entityManager.createQuery(jpql);
				
				for(Object key2 : where.keySet()) {
					Object value2 = where.get(key2);
					query.setParameter((String) key2, value2);
				}
			}
			if ( orderby.size() >0 ){
				order = "Order By";
				Iterator iterator = orderby.keySet().iterator();
				while(iterator.hasNext()){
				  Object key   = iterator.next();
				  Object value = orderby.get(key);
				  order += (String) key + " " +  (String) value ;
				}

				jpql += order;
				
				query = entityManager.createQuery(jpql);
			}
			
			lists = entityManager.createQuery(jpql).getResultList();

		} catch (Exception ee) {

		}

		return lists;
	}

}
