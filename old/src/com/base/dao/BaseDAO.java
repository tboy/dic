package com.base.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDAO<T> {
	@Autowired
	private SessionFactory sessionFactory;

	protected Class<T> entity;

	private Session session;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseDAO() {
		this.entity = ((Class) ((java.lang.reflect.ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0]);

	}

	public Session getSession() {
		if(session == null){
			session = sessionFactory.openSession();
		}
		return session;
	}

	public Session getNewSession() {
		if(session == null){
			session = sessionFactory.openSession();
		}
		return session;
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	public void close() {
		getSession().close();
	}

	/**
	 * hql
	 * 
	 * @param id
	 * @return
	 */
	public Object getObjById(Long id) {
		Object obj = getNewSession().get(entity, id);
		return obj;
	}
	
	public void update(Object obj){
		    Session se =  getNewSession(); 
		    se.beginTransaction(); 
	        se.update(obj);
	        se.getTransaction().commit();
		//getNewSession().saveOrUpdate(obj);
	}

	@SuppressWarnings("rawtypes")
	public List queryByHql(String hql, Map<String, Object> params, int begin, int max) {
		Query sq = getNewSession().createQuery(hql);
		if (params != null) {
			Set keys = params.keySet();
			for (Object key : keys) {
				sq.setParameter(key.toString(), params.get(key));
			}
		}
		if (begin != -1) {
			sq.setFirstResult(begin);
			sq.setMaxResults(max);
		}
		List rs = sq.list();
		return rs;
	}

	public boolean updateByHql(String hql, Map<String, Object> params, int begin, int max) {
		Query sq = getNewSession().createQuery(hql);
		Set keys = params.keySet();
		for (Object key : keys) {
			sq.setParameter(key.toString(), params.get(key));
		}
		if (begin != -1) {
			sq.setFirstResult(begin);
			sq.setMaxResults(max);
		}
		int num = sq.executeUpdate();
		System.out.println("更新了" + num + "条记录！");
		return true;
	}

	/**
	 * 通过sql查询数据
	 * 
	 * @param sql
	 * @param params
	 *            参数
	 * @param begin
	 *            开始索引
	 * @param num
	 *            数量
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List queryBySql(String sql, Object[] params, int begin, int max) {
		SQLQuery sq = getNewSession().createSQLQuery(sql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				sq.setParameter(i, params[i]);
				i++;
			}
		}
		if (begin != -1) {
			sq.setFirstResult(begin);
			sq.setMaxResults(max);
		}
		List rs = sq.list();
		return rs;
	}

	public boolean updateBySql(String sql, Object[] params, int begin, int max) {
		SQLQuery sq = getNewSession().createSQLQuery(sql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				sq.setParameter(i, params[i]);
				i++;
			}
		}
		if (begin != -1) {
			sq.setFirstResult(begin);
			sq.setMaxResults(max);
		}
		Integer num = sq.executeUpdate();
		System.out.println("更新了" + num + "条记录！");
		return true;
	}
}
