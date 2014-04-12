package cn.ts987.oa.action;

import java.io.File;
import java.util.Collection;
import java.util.Date;

import org.springframework.stereotype.Controller;

import cn.ts987.oa.domain.Form;
import cn.ts987.oa.domain.FormTemplate;
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
	
	public String myApplicationList() {
		Collection<FormTemplate> formTemplateList = formTemplateService.list();
		ActionContext.getContext().put("formTemplateList", formTemplateList);
		
		User user = getCurrentUser();
		Collection<Form> recordList = formFlowService.findByUser(user);
		
		ActionContext.getContext().put("recordList", recordList);
		return "myApplicationList";
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
