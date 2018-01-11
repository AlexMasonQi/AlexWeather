<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 2018/1/3
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>在此处插入标题</title>

    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css">
    <script src="<%=basePath%>/js/jquery-3.2.1.min.js"></script>
    <script src="<%=basePath%>/js/bootstrap.min.js"></script>

</head>
<body>
This is a JSP Page
</body>
</html>
