<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/1/23
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<body>
<h2>Hello World!</h2>
<form action="page.do">
   <input type="text" disabled="disabled" name="type" value="国内新闻">
    <input type="hidden" name="method" value="listPage"/>
    <input type="submit" value="提交">
    <%--/newsController.do--%>
</form>
<a href="/test.do" name="method" >测试</a>
<form action="newsController.do"  method="post" enctype="multipart/form-data">
    <input type="file"  name="file" >
    <input type="submit" value="提交">
    <%--/newsController.do--%>
</form>
</body>
</html>
