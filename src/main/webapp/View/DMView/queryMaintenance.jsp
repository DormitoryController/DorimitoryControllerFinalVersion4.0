<%--
  Created by IntelliJ IDEA.
  User: 李朋辉
  Date: 2017/4/28
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>
    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

    <title>queryMaintenance</title>
</head>
<body>
<style>body {
    background-color: #d9edf7;
}
</style>
<script>
    index=1;
    $(document).ready(function queryMaintenance() {
        $.ajax({
            type:'post',
            url:'/DormManage/maintenanceItems',
            success: function (data) {
                var result = eval("(" + data + ")");
                var ob = result.maintenanceList;
                var date = result.dateList;
                for(var i in ob) {
                    var txt= "<tr><td>"+ob[i].id+"</td>" +
                        "<td>"+ob[i].fault_location+"</td>" +
                        "<td>"+ob[i].name+"</td>" +
                        "<td>"+date[i]+"</td>" +
                        "<td><input type='text' id='check1' class='form-control' style='background-color: mintcream'></td>" +
                        "<td><input type='text' id='check2' class='form-control' style='background-color: mintcream'></td>" +
                        "<td>"+ob[i].fault_detail+"</td>" +
                        "<td><button class='btn btn-block btn-success' onclick='maintenanceSubmit("+ob[i].id+")'><i class='ban-circle'></i>提交</button>" +
                        "<button class='btn btn-block btn-warning' onclick='maintenanceDelete("+ob[i].id+")'><i class='ban-circle'></i>删除</button></td>" +
                        "</tr>";
                    $("#content").append(txt);
                }
            },
        },JSON)
    })
    function maintenanceSubmit(id) {
        var id1 = id;
        var fault_state=$("#check1").val();
        var name=$("#check2").val();
        $.ajax({
            type:'post',
            url:'/DormManage/maintenanceSubmit',
            data:{id:id1,fault_state:fault_state,name:name},
            success:function(data) {
                alert("提交成功")
            },
            error:function () {
                alter("服务器异常，提交失败")
            }

        },JSON)
    }
    function maintenanceDelete(id) {
        var id2 = id;
        $.ajax({
            type:'post',
            url:'/DormManage/maintenanceDelete',
            data:{id:id2},
            success:function (data) {
                alert("删除成功")
                location.href="/DormManage/"
            },
            error:function () {
                alter("服务器异常，删除失败")
            }
        },JSON)
    }
</script>
<div class="table-responsive">
<table class="table table-hover">
    <thead>
    <tr style="background-color: #d0e9c6">
        <th class="text-center" width="50px">
            报表
        </th>
        <th class="text-center">
            报修部门
        </th>
        <th class="text-center" width="70px">
            报修人
        </th>
        <th class="text-center">
            报修时间
        </th>
        <th class="text-center">
            审核状态
        </th>
        <th class="text-center">
            维修人
        </th>
        <th class="text-center" width="60px">
            报修信息
        </th>
        <th class="text-center">
            操作
        </th>
    </tr>
    </thead>
    <tbody id="content" style="background-color: #f9f2f4">

    </tbody>
</table>
</div>
</body>
</html>
