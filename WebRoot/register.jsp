<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    <link href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div class="register pull-center">
				<form role="form" actino="/user/register">
					<div class="login-head">注册一个新的账号</div>
					<div id="login-form" class="sign-up">
						<div class="form-group">
						    <label for="exampleInputEmail1">用户名：</label>
						    <input type="text" class="form-control" name="username" id="username" placeholder="请输入用户名" onblur="check_name()">
						    <span class="help-block">请输入5-20位字符.</span>
					    </div>
						
						<div class="form-group">
						    <label for="exampleInputEmail1">密码：</label>
						    <input type="password" class="form-control" name="passW" id="passW" placeholder="请输入密码">
						    <span class="help-block">请输入5-50位字符的密码，字符越长越安全.</span>
					    </div>
						<!--<div class="form-group">
						    <label for="exampleInputEmail1">确认密码：</label>
						    <input type="password" class="form-control" name="passW" id="userPass" placeholder="请输入密码">
					    </div>-->
					</div> 
					<div class="login-bottom">
						<div class="col-sm-5">
						  <button type="submit" id="loginBtn" data-loading-text="登录中..." class="btn btn-info">立即注册</button>
					    </div>
					</div>
				</form>
			</div>
		
     <br>
     <script type="text/javascript" src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	    <script type="text/javascript" src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="/js/register"></script>
	    <script type="text/javascript">
	  $(document).ready(function(){
	$("#username").onblur(function(){
		name_check();
    });
    })
    var name_check= function (){
   // var username=$("#username").val();
    	$.ajax({
		type : "POST",
		url : "/user/register/namecheck",
		dataType : "json",
		contentType : "application/json;charset=utf-8",
		data :username,
		async : false,
		success : function(data) {
			if(data.resultCode == 0){   //登录成功
				
			}else{
				alert(data.resultMessage);
			}
			
		}
	});}
	
	
	    </script>
  </body>
   
</html>
