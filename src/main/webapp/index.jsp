<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 2018/1/3
  Time: 21:14
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

    <title>天气查询,提供全国各地市天气查询服务</title>

    <link rel="icon" href="<%=basePath%>/icons/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>/css/indexstyle.css">
    <script src="<%=basePath%>/js/jquery-3.2.1.min.js"></script>
    <script src="<%=basePath%>/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>/js/indexscript.js"></script>

</head>
<body>
<div class="container">
    <fieldset>
        <div class="row weather">
            <%--输入框--%>
            <div class="col-md-4"></div>
            <div class="form-group col-md-4 nav">
                <label for="inputCity" class="city">所在城市</label>
                <input type="text" class="form-control" id="inputCity" oninput="listenText()"  placeholder="请输入所在城市">
                <br><span style="color:red">注：仅支持国内天气查询，并且暂不支持查询台湾以及南海诸岛</span>
                <%--下拉框--%>
                <div class="select_box" style="display: none">
                    <div class="select_list1">
                        <div class="cy_city">
                            <span class="common-title">&nbsp;&nbsp;&nbsp;常用城市</span>
                            <ul class="list-inline common-city">
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-city">北京</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-city">上海</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-city">杭州</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-city">广州</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-city">深圳</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-city">武汉</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-city">南京</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-city">天津</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-city">长沙</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-city">济南</a>
                                </li>
                            </ul>
                        </div>
                        <div class="pro_list">
                            <span class="common-title">&nbsp;&nbsp;&nbsp;选择省市</span>
                            <ul class="list-inline select-region">
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >北京</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >上海</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >天津</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >重庆</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >安徽</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >福建</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >甘肃</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >广东</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >广西</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >贵州</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >海南</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >黑龙江</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >河北</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >河南</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >湖北</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >湖南</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >吉林</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >江苏</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >江西</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >辽宁</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >内蒙古</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >宁夏</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >青海</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >山东</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >山西</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >陕西</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >四川</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >西藏</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >新疆</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >云南</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >浙江</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >香港</a>
                                </li>
                                <li class="list-inline-item">
                                    <a href="javascript:void(0)" class="com-region" >澳门</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="row select_list2">
                        <div class="region-name"><a href="javascript:void(0)" class="back">&lt;&lt; 返回全国</a><span class="proName"></span></div>
                        <ul class="list-inline city-list">
                        </ul>
                    </div>
                    <div class="select-query list-group">
                    </div>
                </div>
            </div>
            <div class="col-md-4"></div><br>

            <div class="col-md-4"></div>
            <div class="col-md-4" style="padding-left: 0;">
                <label for="submitbtn" class="querybtn">
                    <button type="button" id="submitbtn" class="btn btn-primary btn-lg btn-block">查&nbsp;&nbsp;&nbsp;询</button>
                </label>
            </div>
            <div class="col-md-4"></div>

        </div>
    </fieldset>
</div>
<div class="container show-weather">
    <h3 class="pro-city"></h3>
    <img class="weather-image" src="">&nbsp;&nbsp;<span class="temperature h1"></span>
    <h3 class="weather1"></h3>
    <span class="last-update-time"></span><br>
    <span class="win-direction"></span><span class="wind-speed"></span><span class="humidity"></span>
</div>

<div class="container info">
    <hr>
    <span class="git">贡献到&nbsp;<a href="https://github.com/Baymax6/AlexWeather.git" target="_blank"><img src="<%=basePath%>/icons/GitHub-Mark-Light-32px.png" width="15" height="15">&nbsp;Github</a></span>&nbsp;&nbsp;|&nbsp;&nbsp;京ICP备17067056号
</div>
</body>
</html>
