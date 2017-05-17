<%--
  Created by IntelliJ IDEA.
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/10
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">

    <link href="/CSS/StudentCss/tablecloth/tablecloth.css" rel="stylesheet" type="text/css"  />
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>

    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

    <script type="text/javascript" src="/CSS/StudentCss/tablecloth/tablecloth.js"></script>
    <title>Title</title>

    <style>body {
        background-color: #d9edf7;
    }
    </style>
</head>
<script language="javascript">

    $("#document").ready(function () {
        $.ajax({
            type:'get',
            url:'/StudentView/Stu_seeReform',
            data:{index:0},
            success: function (data) {
                $("#tbody").empty();
                var result = eval("(" + data + ")");
                var ob = result.mlist2;
                var datelist=result.datelist;
                for (var i in ob) {
                    var txt = "<tr>" +
                        "<th>" + ob[i].id+"</th>" +
                        "<th>" + ob[i].fault_detail+"</th>" +
                        "<th>" + ob[i].repairer_id+"</th>" +
                        "<th>" + ob[i].fault_location+"</th>" +
                        "<th>" + datelist[i]+"</th>" +
                        "<th>"+ ob[i].fault_analysis+"</th>" +
                        "<th>"+ ob[i].estimate_detial+"</th>" +
                        "</tr>"
                    $("#tbody").append(txt);
                }
            },
        },JSON)
    })

</script>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-9 column" >
<table cellspacing="0" cellpadding="0">
    <br>
    <p align="center">回执单</p>
    <tr>
        <th id="th1">回执ID</th>
        <th>故障描述</th>
        <th>维修员ID</th>
        <th>地址</th>
        <th>维修时间</th>
        <th>说明</th>
        <th>评价</th>
    </tr>
    <tbody id="tbody">

    </tbody>

</table>
        </div>
    </div>
</div>
</body>
</html>
