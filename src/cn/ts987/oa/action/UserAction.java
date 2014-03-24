package cn.ts987.oa.action;

import java.util.List;

import org.springframework.stereotype.Controller;

import cn.ts987.oa.domain.Department;
import cn.ts987.oa.domain.User;

import com.opensymphony.xwork2.ActionContext;

@Controller("userAction")
public class UserAction extends BaseAction<User>{

	private static final long serialVersionUID = 1L;

	private List<User> userList;
	
	public String list() throws Exception {
		userList = userService.list();
		System.out.println("userList size:  " + userList.size());
		ActionContext.getContext().put("userList", userList);
		
		return "list";
	}
	
	public String add() throws Exception {
		User role = new User();
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		userService.add(role);
		return "toList";
	}
	
	public String update() throws Exception {
		User role = userService.findById(model.getId());
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		userService.update(role);
		return "toList";
	}
	
	public String delete() throws Exception {
		userService.delete(model.getId());
		return "toList";
	}
	
	public String addUI() throws Exception {
		List<Department> departmentList = departmentService.findAll();
		ActionContext.getContext().put("departmentList", departmentList);
		
		return "saveUI";
	}
	
	public String updateUI() throws Exception {
		List<Department> departmentList = departmentService.findAll();
		ActionContext.getContext().put("departmentList", departmentList);
		
		User role = userService.findById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		
		return "saveUI";
	}
	
	public String toList() throws Exception {
		
		return "toList";
	}

	
	

}
