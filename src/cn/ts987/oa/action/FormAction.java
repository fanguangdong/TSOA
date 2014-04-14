package cn.ts987.oa.action;

import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.jbpm.api.task.Task;
import org.springframework.stereotype.Controller;

import cn.ts987.oa.domain.Form;
import cn.ts987.oa.domain.FormTemplate;
import cn.ts987.oa.domain.TaskView;
import cn.ts987.oa.domain.User;

import com.opensymphony.xwork2.ActionContext;

@Controller
public class FormAction extends BaseAction<Form> {
	private static final long serialVersionUID = 1L;
	
	private Long formTemplateId;
	
	private File upload;
	
	public String formTemplateList() {
		Collection<FormTemplate> formTemplateList = formTemplateService.list();
		ActionContext.getContext().put("formTemplateList", formTemplateList);
		return "formTemplateList";
	}
	
	public String submitUI() {
		return "submitUI";
	}
	
	/**
	 * 提交申请
	 * @return
	 */
	public String submit() {
		FormTemplate ft = formTemplateService.getById(formTemplateId);
		
		String path = saveUploadFile(upload);
		Form form = new Form();
		
		form.setApplicant(getCurrentUser());
		form.setApplyTime(new Date());
		form.setFormTemplate(ft);
		form.setStatus(Form.STATUS_REJECTED);
		form.setPath(path);
		form.setTitle(ft.getName());
		
		formFlowService.submit(form);
		
		return "formTemplateList";
	}
	
	/**
	 * 我的申请列表
	 * @return
	 */
	public String myApplicationList() {
		Collection<FormTemplate> formTemplateList = formTemplateService.list();
		ActionContext.getContext().put("formTemplateList", formTemplateList);
		
		User user = getCurrentUser();
		Collection<Form> recordList = formFlowService.findByUser(user);
		
		ActionContext.getContext().put("recordList", recordList);
		return "myApplicationList";
	}
	
	
	/**
	 * 当前用户的待办任务列表
	 * @param formTemplateId
	 */
	public String myTaskList() {
		List<TaskView> taskViewList = formFlowService.getMyTaskList(getCurrentUser());
		ActionContext.getContext().put("taskViewList", taskViewList);
		return "myTaskList";
	}
	
	
	
	public void setFormTemplateId(Long formTemplateId) {
		this.formTemplateId = formTemplateId;
	}

	public Long getFormTemplateId() {
		return formTemplateId;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public File getUpload() {
		return upload;
	}
}
