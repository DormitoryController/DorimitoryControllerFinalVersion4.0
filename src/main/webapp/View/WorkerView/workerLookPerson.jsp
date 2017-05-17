<%--
  Created by IntelliJ IDEA.
  User: Administration
  Date: 2017/5/11
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<html>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>
    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <title>报修处理系统</title>
    <style>
        body {
            background-color: #d9edf7;
        }
        #workerhistory{
            width: 995px;
            margin-left: -45px;
        }
    </style>
</head>
<script>

    $("#document").ready(function () {
        $.ajax({
            type:'get',
            url:'/workerHandleController/workerLookPerson',
            data:{index:0},
            success: function (data) {
                //alert(data+"iiii");
                $("#tbody").empty();
                var result = eval("(" + data + ")");
                var ob = result.list1;
                for (i in ob) {
                    var txt = "<tr>" +
                        "<th id='th1'>" + ob[i].id + "</th>" +
                        "<th>" + ob[i].username+ "</th>" +
                        "<th>" + ob[i].sex+"</th>" +
                        "<th>" + ob[i].repairer_type + "</th>" +
                        "<th>" + ob[i].officenum + "</th>" +
                        "<th>" + ob[i].telephone + "</th>" +
                        "<th>" + ob[i].email + "</th>" +
                        "</tr>";
                    $("#tbody").append(txt);
                }
            },
        },JSON)
    })


</script>

<body>
<div class="container">
    <div class="row clearfix" >
        <div class="col-md-9 column" >
            <div class="jumbotron well">
                <table class="table">

                    <p>个人信息</p>
                    <tr >
                        <th id="th1">编号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>工种</th>
                        <th>办公室</th>
                        <th>电话</th>
                        <th>邮箱</th>
                    </tr>
                    <tbody id="tbody">

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
