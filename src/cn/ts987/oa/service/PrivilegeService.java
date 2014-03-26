package cn.ts987.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ts987.oa.domain.Privilege;

@Service("privilegeService")
@Transactional
public class PrivilegeService extends BaseService {

	public List<Privilege> findAll() {
		
		return privilegeDao.findAll();
	}
	
}
