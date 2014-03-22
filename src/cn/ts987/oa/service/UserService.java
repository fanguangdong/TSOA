package cn.ts987.oa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ts987.oa.dao.IBaseDao;
import cn.ts987.oa.domain.User;

@Service("userService")
public class UserService {
	
	@Resource(name="userDao")
	private IBaseDao<User> userDao;
	
	@Transactional
	public List<User> list() {
		List<User> UserList = userDao.findAll();
		return UserList;
	}
	
	@Transactional
	public void add(User entity) {
		userDao.save(entity);
	}
	
	@Transactional
	public void update(User entity) {
		userDao.update(entity);
	}
	
	@Transactional
	public void delete(long id) {
		userDao.delete(id);
	}

	@Transactional
	public User findById(long id) {
		
		return userDao.findById(id);
	}
	
}
