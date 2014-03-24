package cn.ts987.oa.service;

import javax.annotation.Resource;

import cn.ts987.oa.dao.IBaseDao;
import cn.ts987.oa.domain.Department;
import cn.ts987.oa.domain.User;

public abstract class BaseService {
	
	@Resource(name="userDao")
	protected IBaseDao<User> userDao;
	
	@Resource(name="departmentDao")
	protected IBaseDao<Department> departmentDao;	
	
	
}
