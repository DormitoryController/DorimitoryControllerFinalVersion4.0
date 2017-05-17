<%--
  Created by IntelliJ IDEA.
  User: 李朋辉
  Date: 2017/4/28
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>
    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

    <title>queryRepairer</title>
</head>
<body>
<style>body {
    background-color: #d9edf7;
}
</style>
<script>
    $("#document").ready(function queryRepairer() {
        $.ajax({
            type: 'post',
            url: '/DormManage/repairerItems',
            success: function (data) {
                $("#tbody").empty();
                var result = eval("(" + data + ")");
                var ob = result.repairerList;
                for (var i in ob) {
                    var txt = "<tr><td>" + ob[i].id +
                        "</td><td>" + ob[i].name +
                        "</td><td>" + ob[i].repairer_type +
                        "</td><td>" + ob[i].state + "</td></tr>"
                    $("#con").append(txt);
                }
            },
        }, JSON)
    })
</script>
<div class="table-responsive">
<table class="table table-hover">
    <thead>
    <tr style="background-color: #dff0d8">
        <th>
            维修员id
        </th>
        <th>
            维修员名称
        </th>
        <th>
            维修人员类型
        </th>
        <th>
            状态
        </th>
    </tr>
    </thead>
    <tbody id="con" style="background-color: #f9f2f4">

    </tbody>
</table>
</div>
</body>
</html>
