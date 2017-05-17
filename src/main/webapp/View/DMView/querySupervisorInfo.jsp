<%--
  Created by IntelliJ IDEA.
  User: Heisenberg
  Date: 2017/5/3
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>
    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

    <title>querySupervisorInfo</title>
</head>
<body>
<style>body {
    background-color: #d9edf7;
}
</style>
<script>
    index=1;
    $(document).ready(function querySupervisorInfo() {
        $.ajax({
            type:'post',
            url:'/DormManage/supervisorItems',
            success: function (data) {
                var result = eval("(" + data + ")");
                var ob = result.supervisorList;
                for(var i in ob) {
                    var txt= "<tr class='text-center'><td>" + ob[i].username + "</td>" +
                        "<td>" + ob[i].name + "</td>" +
                        "<td>" + ob[i].sex + "</td>" +
                        "<td>" + ob[i].telephone + "</td>" +
                        "<td>" + ob[i].email + "</td>" +
                        "<td>" + ob[i].officenum + "</td>" +
                        "</tr>";
                    $("#supquery").append(txt);
                }
            },
        },JSON)
    })
</script>

<table class="table table-hover">
    <thead>
    <tr style="background-color: #d0e9c6">
        <th width="80px" class="text-center">
            用户名
        </th>
        <th class="text-center">
            姓名
        </th>
        <th class="text-center">
            性别
        </th>
        <th class="text-center">
            电话
        </th>
        <th class="text-center">
            邮箱
        </th>
        <th class="text-center">
            办公室
        </th>
    </tr>
    </thead>
    <tbody id="supquery" style="background-color: #f9f2f4">

    </tbody>
</table>

</body>
</html>
