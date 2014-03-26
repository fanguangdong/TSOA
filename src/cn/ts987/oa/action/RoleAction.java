package cn.ts987.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ts987.oa.domain.Privilege;
import cn.ts987.oa.domain.Role;

import com.opensymphony.xwork2.ActionContext;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	private static final long serialVersionUID = 1L;
	
	private List<Role> roleList;
	
	
	private List<Privilege> privilegeList;
	
	public String setPrivilegeUI() {
		this.privilegeList = privilegeService.findAll();
		return "setPrivilegeUI";
	}
	
	public String list() throws Exception {
		roleList = roleService.list();
		System.out.println("roleList size:  " + roleList.size());
		ActionContext.getContext().put("roleList", roleList);
		return "list";
		
	}
	
	public String add() throws Exception {
		Role role = new Role();
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		roleService.add(role);
		return "toList";
	}
	
	public String update() throws Exception {
		Role role = roleService.findById(model.getId());
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		roleService.update(role);
		return "toList";
	}
	
	public String delete() throws Exception {
		roleService.delete(model.getId());
		return "toList";
	}
	
	public String addUI() throws Exception {
		
		return "saveUI";
	}
	
	public String updateUI() throws Exception {
		Role role = roleService.findById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		
		return "saveUI";
	}
	
	public String toList() throws Exception {
		
		return "toList";
	}

	public void setPrivilegeList(List<Privilege> privilegeList) {
		this.privilegeList = privilegeList;
	}

	public List<Privilege> getPrivilegeList() {
		return privilegeList;
	}

	

}
