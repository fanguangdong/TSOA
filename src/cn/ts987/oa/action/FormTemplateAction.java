package cn.ts987.oa.action;

import java.io.File;
import java.util.Collection;

import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ts987.oa.domain.FormTemplate;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class FormTemplateAction extends BaseAction<FormTemplate>{
	private static final long serialVersionUID = 1L;
	
	private File upload;  //上传的模板 
	
	public String list() {
		Collection<FormTemplate> formTemplateList = formTemplateService.list();
		ActionContext.getContext().put("formTemplateList", formTemplateList);
		
		return "list";
	}
	
	public String addUI() {
		Collection<ProcessDefinition> processDefinitionList = processDefinitionService.findAllLatestVersions();
		
		ActionContext.getContext().put("processDefinitionList", processDefinitionList);
		return "addUI";
	}
	
	public String add() {
		FormTemplate ft = model;
		
		String filePath = saveUploadFile(upload);
		ft.setPath(filePath);
		formTemplateService.add(ft);
		return "toList";
	}
	
	public String delete() {
		
		return "toList";
	}

	
	
	
	/* Getters and Setters */
	
	public void setUpload(File upload) {
		this.upload = upload;
	}

	public File getUpload() {
		return upload;
	}
	
	
}
