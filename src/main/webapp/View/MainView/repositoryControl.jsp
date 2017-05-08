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
    function repositoryTable() {
        $("#div1").load("http://localhost:8001/repositoryTable")
    }
</script>
<body>
<style>body {
    background-color: #d9edf7;
}
</style>
<div class="tabbable" id="tabs-795087">
    <ul class="nav nav-tabs">
        <li class="active">
            <a href="#panel-453243" data-toggle="tab" id="pane1" onclick="repositoryTable()">仓库管理</a>
        </li>
        <li>
            <a href="#panel-573909" data-toggle="tab">仓库信息</a>
        </li>
    </ul>
    <div class="tab-content">
        <div class="tab-pane active" id="panel-453243">
            <div id="div1"></div>
        </div>
        <div class="tab-pane" id="panel-573909">
            <p>
                Howdy, I'm in Section 2.
            </p>
        </div>
    </div>
</div>
</body>
</html>
