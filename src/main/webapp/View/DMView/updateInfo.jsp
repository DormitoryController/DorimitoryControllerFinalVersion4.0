<%--
  Created by IntelliJ IDEA.
  User: 李朋辉
  Date: 2017/5/3
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>
    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

    <title>updateInfo</title>
</head>
<body>
<style>body {
    background-color: #d9edf7;
}
</style>
<script>
    index=1;
    $(document).ready(function updateInfo() {
        $.ajax({
            type:'post',
            url:'/DormManage/supervisorItems',
            success: function (data) {
                var result = eval("(" + data + ")");
                var ob = result.supervisorList;
                for(var i in ob) {
                    var txt= "<tr><td id='mycheck'>"+ob[i].username+"</td>" +
                        "<td><input type='text' id='check1' class='form-control' style='background-color: mintcream'></td>" +
                        "<td><input type='text' id='check2' class='form-control' style='background-color: mintcream'></td>" +
                        "<td><input type='tel' id='check3' class='form-control' style='background-color: mintcream'></td>" +
                        "<td><input type='email' id='check4' class='form-control' style='background-color: mintcream'></td>" +
                        "<td><input type='text' id='check5' class='form-control' style='background-color: mintcream'></td>" +
                        "<td><button class='btn btn-block btn-success' onclick='supervisorUpdate()'><i class='ban-circle'></i>提交</button></td>" +
                        "</tr>";
                    $("#supervisor").append(txt);
                }
            },
        },JSON)
    })
    function supervisorUpdate() {
        var username1 =$("#mycheck").text();
        var name=$("#check1").val();
        var sex=$("#check2").val();
        var telephone=$("#check3").val();
        var email=$("#check4").val();
        var officenum=$("#check5").val();
        $.ajax({
            type:'post',
            url:'/DormManage/supervisorUpdate',
            data:{username:username1, name:name, sex:sex, telephone:telephone, email:email, officenum:officenum},
            success:function(data) {
                alert("提交成功")
            },
            error:function () {
                alter("服务器异常，提交失败")
            }

        },JSON)
    }
</script>
<div class="table-responsive">
<table class="table table-hover">
    <thead>
    <tr style="background-color: #d0e9c6">
        <th class="text-center" width="80px">
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
        <th >
            操作
        </th>
    </tr>
    </thead>
    <tbody id="supervisor" style="background-color: #f9f2f4">

    </tbody>
</table>
</div>
</body>
</html>
