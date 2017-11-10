package com.base.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.base.dao.BaseDAO;
@SuppressWarnings("unchecked")
public class BaseService<T>{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Class<T> entity;
	public BaseService() {
		this.entity = ((Class) ((java.lang.reflect.ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0]);

	}
    @Autowired
    private BaseDAO<T> dao;
    public BaseDAO<T> cuDao() {
		return dao;
	}
	
	public T getObjById(Long id) {
		return (T)dao.getObjById(id);
	}

	public void saveOrUpdate(T entity){
		dao.update(entity);
	}
	
	public PageUtil list(String hql,Map<String,Object> params,int page,int pageSize) {
		int begin = (page-1)*pageSize;
		int max = pageSize;
		int num  = dao.queryByHql(hql, params, -1, -1).size();
		List<T> rs = (List<T>)dao.queryByHql(hql, params, begin, max);
		PageUtil pageUtil = new PageUtil();
		pageUtil.page = page;
		pageUtil.pages = num%pageSize == 0?(num/pageSize):Integer.parseInt((num/pageSize)+"")+1;
		pageUtil.result = rs;
		return pageUtil;
	}
	
	@SuppressWarnings("rawtypes")
	public List listSql(String sql,Object[] params,int page,int pageSize) {
		int begin = (page-1)*pageSize;
		int max = pageSize;
		List rs = dao.queryBySql(sql, params, begin, max);
		return rs;
	}
	
}
