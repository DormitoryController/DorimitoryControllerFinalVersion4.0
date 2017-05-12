<%--
  Created by IntelliJ IDEA.
  User: 赵嗣瑜
  Date: 2017/4/25
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>repositoryControl</title>
    <meta charset="UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>

    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>


</head>
<script>
    function repositoryControlAdd() {
        $("#div1").load("/MainController/repositoryTable")
    }
    function repositoryControlReduce() {
        $("#div2").load("/MainController/repositoryTableReducing")
    }
</script>
<body>
<style>body {
background-color: #d9edf7;
}
</style>
<div class="tabbable" >
    <ul class="nav nav-tabs">
        <li class="active">
            <a href="#panel-453243" data-toggle="tab"  onclick="repositoryControlAdd()">耗材提交</a>
        </li>
        <li>
            <a href="#panel-573909" data-toggle="tab"  onclick="repositoryControlReduce()">采购信息提交</a>
        </li>
    </ul>
    <div class="tab-content">
        <div class="tab-pane active" id="panel-453243">
            <div id="div1"></div>
        </div>
        <div class="tab-pane" id="panel-573909">
            <div id="div2"></div>
        </div>
    </div>
</div>
</body>
</html>
