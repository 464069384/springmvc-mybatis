<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登陆</title>
<script type="text/javascript">
	function reloadVerifyCode(){
		var dateTime=new Date().getTime();
		document.getElementById("safecode").src="<%=request.getContextPath() %>/verifyCode?time="+dateTime;
	} 
</script>
</head>

<body>
		<form action="<c:url value="/user/login.do"/>" method="post">
			用户名：<input type="text" name="userName"/><br/>
			密码：<input type="password" name="password"/><br/>
			验证码：<img alt="验证码" id="safecode" src="<c:url value="/verifyCode"/>"/><br/>
			<a href="javascript:reloadVerifyCode();">看不清楚</a>  <br/>
			<input type="text" name="userCode"/><br/>
			<input type="submit" value="登录"/>
			<input type="reset" value="重置"/>
		</form>
</body>
</html>