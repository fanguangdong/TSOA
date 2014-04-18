<%@ page language="java" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>部署流程定义</title>
<%@ include file="/commons/common.jsp"%>


<!--框架必需start-->
<script type="text/javascript" src="libs/js/jquery.js"></script>
<script type="text/javascript" src="libs/js/framework.js"></script>
<link href="libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=request.getContextPath() %>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->
</head>
<body>
<div id="scrollContent">
	<div class="box2" panelWidth="500" panelTitle="上传流程定义文档">
	
		<s:form action="processDefinition_add" enctype="multipart/form-data">
			<table class="tableStyle">
				<tr><td colspan="2"></td></tr>
				
				<tr><td width="150">请选择流程定义文档(zip格式)：</td> <td><input type="file" name="upload"/></td></tr>
				
				<tr><td colspan="2"><input type="submit" value="提交"/>&nbsp;<input type="reset" value="重置"/></td></tr>
				
			</table>
		</s:form>
	</div>
	
	
</div>
</body>
</html>

