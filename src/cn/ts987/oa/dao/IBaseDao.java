package cn.ts987.oa.dao;

import java.util.Collection;
import java.util.List;

import cn.ts987.oa.domain.User;

public interface IBaseDao<T> {
	
	public void save(T entity);
	
	public void delete(long id);
	
	public void update(T entity);
	
	public T findById(long id);
	
	public List<T> findByIds(Collection<Long> ids);

	public List<T> findAll();

}

