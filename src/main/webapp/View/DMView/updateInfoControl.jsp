<%--
  Created by IntelliJ IDEA.
  User: 李朋辉
  Date: 2017/5/3
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>
    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

    <title>updateInfoControl</title>

    <script>
        function querySupervisorInfo() {
            $("#div33").load("/DormManage/querySupervisorInfo")
        }
        function updateInfo() {
            $("#div44").load("/DormManage/updateInfo")
        }
    </script>
<body>
<style>body {
    background-color: #d9edf7;
}
</style>
<div class="table" >
    <ul class="nav nav-tabs" id="tabs-795090">
        <li>
            <a href="#panel-453255" data-toggle="tab" class="btn-block btn-info" onclick="querySupervisorInfo()">个人信息</a>
        </li>
        <li class="active">
            <a href="#panel-453266" data-toggle="tab" class="btn-block btn-info" onclick="updateInfo()">信息修改</a>
        </li>
    </ul>
    <div class="tab-content">
        <div class="tab-pane active" id="panel-453255">
            <div id="div33"></div>
        </div>
        <div class="tab-pane" id="panel-453266">
            <div id="div44"></div>
        </div>
    </div>
</div>
</body>
</html>