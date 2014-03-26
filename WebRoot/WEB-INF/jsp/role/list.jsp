<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
    <title>岗位列表</title>
    
	<%@include file="../common.jsp" %>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 岗位管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="200px">岗位名称</td>
                <td width="300px">岗位说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer">
        	<s:iterator value="#roleList">
				<tr class="TableDetail1 template">
					<td><s:property value="name" /></td>
					<td><s:property value="description" /></td>
					
					<td>
					    <s:a action="role_delete?id=%{id}" onclick="return delConfirm()">删除         </s:a> 
						<s:a action="role_updateUI?id=%{id}">修改      </s:a> 
						
						<s:a href="role_setPrivilegeUI.action?id=%{id}">设置权限    </s:a> 
					</td>
				</tr>
			</s:iterator> 	
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
        	<s:a action="role_addUI"><img src="style/images/createNew.png" /></s:a><br/>
         
        </div>
    </div>
</div>
</body>
</html>

  	
