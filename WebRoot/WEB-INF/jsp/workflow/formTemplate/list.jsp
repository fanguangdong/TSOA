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
</head>
<body>
<div class="box2" panelTitle="功能面板" roller="false">
	
	<table>
		<tr>
			<td><button type="button" onclick="window.location.href='formTemplate_addUI.action'"><span class="icon_reload">增加流程模板</span></button></td>
		</tr>
	</table>
	 
</div>
		<!-- 
<div class="box_tool_min padding_top2 padding_bottom2 padding_right5">
	<div class="center">
	<div class="left">
	<div class="right">
		<div class="padding_top5 padding_left10">
		<a href="javascript:;" onclick="window.location.href='formTemplate_addUI.action'"><span class="icon_add">增加流程模板</span></a>
		
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
	<form action="userAction.do?method=getUsersBasic" method="post" id="usersForm">
	<table class="tableStyle" useClick="false"  useCheckBox="true" sortMode="true">
		<tr>
			<th width="1"></th>
			<th width="30"><span  id="span_userName">模板名称</span></th>
			<th width="30"><span id="span_userLoginName">所用流程</span></th>
		
			<th width="80">相关操作</th>
		</tr>
		
		
		<s:iterator value="#formTemplateList">
			<tr>
				<td><input type="checkbox"/></td>
				<td>${name}&nbsp;</td>
				<td>${pdKey}&nbsp;</td>
				<td>
					<s:a action="formTemplate_delete?id=%{id}" onclick="return delConfirm()">删除</s:a>
					<s:a action="formTemplate_updateUI?id=%{id}">修改</s:a>
					<s:a action="formTemplate_download?id=%{id}">下载</s:a>
				</td>
			</tr>
		</s:iterator>
		
		<!-- 
		<tr>
			<td><input type="checkbox"/></td>
			<td>张小三</td>
			<td>zhangsan</td>
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
		top.Dialog.open({URL:"sample/layout/user-management-content.html",Title:"新增",Width:500,Height:330}); 
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
		top.Dialog.open({URL:"sample/layout/user-management-content2.html",Title:"查看",Width:500,Height:330}); 
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
    