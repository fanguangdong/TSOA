package cn.ts987.oa.action;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import cn.ts987.oa.service.DepartmentService;
import cn.ts987.oa.service.PrivilegeService;
import cn.ts987.oa.service.RoleService;
import cn.ts987.oa.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public BaseAction() {
		
		Type[] actualGenericTypes = ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments();
		
			//model = (T) actualGenericTypes[0].getClass().newInstance();
			Class<T> clazz = (Class<T>)actualGenericTypes[0];
			
			try {
				model = (T) Class.forName(clazz.getName()).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	protected T model = null;
	
	@Override
	public T getModel() {
		return model;
	}
	
	@Resource(name="departmentService")
	protected DepartmentService departmentService; 
	
	@Resource
	protected RoleService roleService;
	
	@Resource
	protected UserService userService;
	
	@Resource
	protected PrivilegeService privilegeService;

}
