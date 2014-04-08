package cn.ts987.oa.service;

import javax.annotation.Resource;

import org.jbpm.api.ProcessEngine;

import cn.ts987.oa.dao.IBaseDao;
import cn.ts987.oa.domain.Department;
import cn.ts987.oa.domain.Privilege;
import cn.ts987.oa.domain.Role;
import cn.ts987.oa.domain.User;

public abstract class BaseService {
	
	@Resource(name="userDao")
	protected IBaseDao<User> userDao;
	
	@Resource(name="roleDao")
	protected IBaseDao<Role> roleDao;
	
	@Resource(name="departmentDao")
	protected IBaseDao<Department> departmentDao;	
	
	@Resource(name="privilegeDao")
	protected IBaseDao<Privilege> privilegeDao;
	
	@Resource(name="processEngine")
	protected ProcessEngine processEngine;
}
