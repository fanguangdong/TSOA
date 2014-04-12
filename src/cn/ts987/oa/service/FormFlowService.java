package cn.ts987.oa.service;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ts987.oa.dao.FormFlowDao;
import cn.ts987.oa.domain.Form;
import cn.ts987.oa.domain.User;

@Service("formFlowService")
@Transactional
public class FormFlowService extends BaseService{

	public Form getById(Long id) {
		Form form = formFlowDao.findById(id);
		return form;
	}

	public void save(Form form) {
		formFlowDao.save(form);
	}

	public Collection<Form> findByUser(User user) {
		
		return ((FormFlowDao)formFlowDao).findByUser(user);
	}
	
	/**
	 * 保存表单，开始流转
	 */
	public void submit(Form form) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 1，设置属性并保存表单
		form.setTitle(form.getFormTemplate().getName() // 标题的格式为：{模板名称}_{申请人姓名}_{申请时间}
				+ "_" + form.getApplicant().getName() //
				+ "_" + sdf.format(form.getApplyTime()));
		form.setStatus(Form.STATUS_RUNNING); // 状态为正在审批中
		formFlowDao.save(form);
		
		//2、  开始流转  
		//a 启动流程实例，并设置流程变量
		String processDefinitionKey = form.getFormTemplate().getPdKey();
		Map<String, Form> variables = new HashMap<String, Form>();
		variables.put("form", form);
		@SuppressWarnings("unused")
		ProcessInstance pi = processEngine.getExecutionService().startProcessInstanceByKey(processDefinitionKey, variables);
		
		//b   完成第一个任务“提交申请”
		User user = getCurrentUser();
		List<Task> list = processEngine.getTaskService().findPersonalTasks(user.getLoginName());
		String taskId = list.get(0).getId();
		
		/*String taskId = processEngine.getTaskService()//
			.createTaskQuery()//询出本流程实例中当前仅有一个任务（提交申请的任务）
			.processInstanceId(pi.getId())//
			.uniqueResult()//
			.getId();*/
		
		processEngine.getTaskService().completeTask(taskId);   // 完成任务
		
	}
	
}









