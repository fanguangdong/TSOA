package cn.ts987.oa.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ts987.oa.domain.Role;
import cn.ts987.oa.service.RoleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends ActionSupport implements ModelDriven<Role>{
	private static final long serialVersionUID = 1L;
	
	private List<Role> roleList;
	
	private Role model = new Role();
	
	@Resource
	private RoleService roleService;

	@Override
	public Role getModel() {
		return model;
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

	

}
