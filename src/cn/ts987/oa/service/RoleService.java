package cn.ts987.oa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ts987.oa.dao.IBaseDao;
import cn.ts987.oa.domain.Role;

@Service
public class RoleService {
	
	@Resource(name="roleDao")
	private IBaseDao<Role> roleDao;
	
	@Transactional
	public List<Role> list() {
		List<Role> roleList = roleDao.findAll();
		return roleList;
	}
	
	@Transactional
	public void add(Role entity) {
		roleDao.save(entity);
	}
	
	@Transactional
	public void update(Role entity) {
		roleDao.update(entity);
	}
	
	@Transactional
	public void delete(long id) {
		roleDao.delete(id);
	}

	@Transactional
	public Role findById(long id) {
		
		return roleDao.findById(id);
	}
	
}
