<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${sessionScope.get(a)}
${sessionScope.a}
<%
 session.getAttribute("a");
%>
测试成功
</body>
</html>
