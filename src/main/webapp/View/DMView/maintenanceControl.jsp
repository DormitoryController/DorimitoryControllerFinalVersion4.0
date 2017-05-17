<%--
  Created by IntelliJ IDEA.
  User: 李朋辉
  Date: 2017/4/27
  Time: :09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>
    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

    <title>maintenanceControl</title>

    <script>
        function queryMaintenance() {
            $("#div11").load("http://localhost:8001/DormManage/queryMaintenance")
        }
        function queryRepairer() {
            $("#div22").load("http://localhost:8001/DormManage/queryRepairer")
        }
    </script>
<body>
<style>body {
    background-color: #d9edf7;
}
</style>
<div class="table" >
    <ul class="nav nav-tabs" id="tabs-795088">
        <li>
            <a href="#panel-453244" data-toggle="tab" class="btn-block btn-info" onclick="queryMaintenance()">维修表查询</a>
        </li>
        <li class="active">
            <a href="#panel-573910" data-toggle="tab" class="btn-block btn-info" onclick="queryRepairer()">维修员查询</a>
        </li>
    </ul>
    <div class="tab-content">
        <div class="tab-pane active" id="panel-453244">
            <div id="div11"></div>
        </div>
        <div class="tab-pane" id="panel-573910">
            <div id="div22"></div>
        </div>
    </div>
</div>
</body>
</html>