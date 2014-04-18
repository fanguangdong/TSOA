<%@ page language="java" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<%@include file="../../../../commons/common.jsp" %>

<!--框架必需start-->
<script type="text/javascript" src="libs/js/jquery.js"></script>
<script type="text/javascript" src="libs/js/framework.js"></script>
<link href="libs/css/import_basic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" id="skin" prePath="<%=request.getContextPath() %>/"/>
<link rel="stylesheet" type="text/css" id="customSkin"/>
<!--框架必需end-->

<!-- 日期选择框start -->
<script type="text/javascript" src="libs/js/form/datePicker/WdatePicker.js"></script>
<!-- 日期选择框end -->

<!--数字分页start-->
<script type="text/javascript" src="libs/js/nav/pageNumber.js"></script>
<!--数字分页end-->


<!-- 业务相关 -->
<script type="text/javascript">
	    function showProcessImage( pdId ){
	    	pdId = encodeURI(pdId); // 进行URL编码
	    	pdId = encodeURI(pdId); // 进行URL编码（第2次）
	    	var url = "${pageContext.request.contextPath}/processDefinition_showProcessImage.action?pdId=" + pdId + "&t=" + new Date();
	    	
	    	window.showModalDialog(url, null, "dialogHeight:500px; dialogWidth:600px; resizable:yes");
        }
        
        function deleteProcessDefinition(pdKey) {
        	pdKey = encodeURI(pdKey);
        	return pdKey;
        }
        
        function deleteRecord(id) {
        	var r = false;
        	top.Dialog.confirm(info, function(){r = true;},function(){r = false;});
        	return r;
        }
    </script> 
</head>
<body>

 
<div class="box2" panelTitle="功能面板" roller="false">
	<table>
		<tr>
			<!-- 
			<td>流程名称：</td>
			<td><input id="query_userName" type="text"/></td>
			<td><button type="button" onclick="searchHandler()"><span class="icon_find">查询</span></button></td>
			 -->
			<td><button type="button" onclick="window.location.href='processDefinition_addUI.action'"><span class="icon_reload">部署流程定义文档</span></button></td>
			<td><div class="red">&nbsp;</div></td>
		</tr>
	</table>
</div>

<!--
<div class="box_tool_min padding_top2 padding_bottom2 padding_right5">
	<div class="center">
	<div class="left">
	<div class="right">
		<div class="padding_top5 padding_left10">
		<a href="javascript:;" onclick="addUser()"><span class="icon_add">新增用户</span></a>
		<div class="box_tool_line"></div>
		<a href="javascript:;" onclick="deleteUser()"><span class="icon_delete">批量删除</span></a>
		<div class="box_tool_line"></div>
		<a href="javascript:;" onclick="importUser()"><span class="icon_import">导入</span></a>
		<div class="box_tool_line"></div>
		<a href="javascript:;" onclick="exportUser()"><span class="icon_export">导出当前页</span></a>
		<div class="box_tool_line"></div>
		<a href="javascript:;"  onclick="exportUser2()"><span class="icon_export">导出全部</span></a>
		<div class="clear"></div>
		</div>
	</div>		
	</div>	
	</div>
	<div class="clear"></div>
</div> 

 -->
<div id="scrollContent" >
	<form action="/userAction.do?method=getUsersBasic" method="post" id="usersForm">
	<table class="tableStyle" useClick="false"  useCheckBox="true" sortMode="true">
	
		<tr>
			<th width="1"></th>
			<th width="10"><span  id="span_userName">流程名称</span></th>
			<th width="1"><span id="span_userLoginName">最新版本</span></th>
			<th width="30"><span id="span_orgName">流程描述</span></th>
			<th width="40">相关操作</th>
		</tr>
		
		<s:iterator value="#pdList">
			<tr>
				<td><input type="checkbox"/></td>
				<td>${name}</td>
				<td>${version}</td>	
				<td>${description}</td>
				
				<td>
					<a href="javascript: showProcessImage('${id}')"> 查看流程图    &nbsp;&nbsp;</a> 
					
					
					
					<s:a action="processDefinition_delete"> 
						<s:param name="key">${key}</s:param>删除   
					</s:a>
				</td>
			</tr>
        </s:iterator>
		
		
		<!-- 
		<tr>
			<td><input type="checkbox"/></td>
			<td>张小三</td>
			<td>zhangsan</td>
			<td>市场部</td>
	
			<td><span class="img_view hand" title="查看流程图" onclick="onView()"></span><span class="img_edit hand" title="修改" onclick="onEdit()"></span><span class="img_delete hand" title="删除" onclick="onDelete()"></span></td>
		</tr>
		
		<tr>
			<td><input type="checkbox"/></td>
			<td>张小三</td>
			<td>zhangsan</td>
			<td>市场部</td>
	
			<td><span class="img_view hand" title="查看" onclick="onView()"></span><span class="img_edit hand" title="修改" onclick="onEdit()"></span><span class="img_delete hand" title="删除" onclick="onDelete()"></span></td>
		</tr>
		 -->
		
	</table>
	</form>
</div>
<div style="height:35px;">
	<div class="float_left padding5">
		数据共200条
	</div>
	<div class="float_right padding5">
		<div class="pageNumber" total="200" pageSize="20" showSelect="true" showInput="true" id="pageContent"></div>
	</div>
	<div class="clear"></div>
</div>
<script type="text/javascript">

///添加
	function addUser() {
		top.Dialog.open({URL:"../../sample/layout/user-management-content.html",Title:"新增",Width:500,Height:330}); 
	}
	
	//批量删除
	function deleteUser() {
		top.Dialog.alert("向后台发送ajax请求来批量删除。见JAVA版或.NET版演示。");
	}
	
	//导入
	function importUser() {
		top.Dialog.alert("见JAVA版或.NET版演示。");
	}
	//导出
	function exportUser() {
		top.Dialog.alert("见JAVA版或.NET版演示。");
	}
	
	//导出所有
	function exportUser2() {
		top.Dialog.alert("见JAVA版或.NET版演示。");
	}
	
	//查看
	function onView(){
		top.Dialog.open({URL:"../../sample/layout/user-management-content2.html",Title:"查看",Width:500,Height:330}); 
	}
	
	//修改
	function onEdit(){
		top.Dialog.alert("见JAVA版或.NET版演示。");
	}
	
	//删除
	function onDelete(){
		top.Dialog.confirm("确定要删除该记录吗？",function(){
		  	top.Dialog.alert("向后台发送ajax请求来删除。见JAVA版或.NET版演示。");
		});
	}
</script>
</body>
</html>
	