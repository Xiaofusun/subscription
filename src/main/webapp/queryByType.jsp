<%@ page import="java.util.List" %>
<%@ page import="cr.model.News" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/1/23
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<head>
<script type="text/javascript">
</script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>医疗资讯_医疗新闻</title>
</head>
<body>
<div id="chan_newsBlk">
    <div id="chan_newsDetail">
           <c:forEach  items="${sessionScope.newsList}" var="news">
            <div class="list-li">
            <img src="http://${news.pic}" alt="${news.newstitle}" style="display: block;">
            <h3><a href="body.do?method=queryByIdBody&bid=${news.newsid}" target="_blank" title="${news.newstitle}">${news.newstitle}</a></h3>
            <div class="info clearfix">
                <<div class="time"> <span><em>${news.newstype}</em> </span>| <span>${news.newsdate}</span></div>-->
            </div>
            <a class="txt" href="test.do?method=res&id=${news.newsid}" target="_blank"><p>
            ${news.newssummary}
            </a>
        </div>
           </c:forEach>

            <span class="pageinfo">共 <strong>75</strong>页<strong>749</strong>条</span>
        </div>

    </div>
</div>
<%--<DIV class="edit_related2013" id="edit_related2013"></DIV>
<DIV class="sharetobox"></DIV >

<DIV id="chan_attach"></DIV>
</div>
<span class="info clearfix"><span class="bdshare_b" style="line-height: 12px;"><img src="http://bdimg.share.baidu.com/static/images/type-button-1.jpg?cdnversion=20120831" /></span></span>
<div class="arcright">
    <DIV class="gg300">
        <script src='/plus/ad_js.php?aid=8' language='javascript'></script>
    </div>

    <div class="footer">
        <div id="about">Copyright &copy; 2013-2016 医疗新闻网 版权所有！  （免责声明：部分内容有网站机器人整理于互联网，若侵犯到您的权利请及时联系站长删除，谢谢！）</div>
    </div>
</div>
--%>

</body>
</html>

