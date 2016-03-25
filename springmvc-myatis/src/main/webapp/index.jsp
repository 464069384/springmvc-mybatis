<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index page</title>
</head>
<body>
	非admin页面
	<a href="logout">登出</a>
	
	<security:authorize access="hasRole('ROLE_ADMIN')" >
			只有管理员权限才能看到
	</security:authorize>
	
</body>
</html>