<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/10
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>

    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <title>Title</title>

    <style>body {
        background-color: #d9edf7;
    }

    #qq{
        border-style: solid;
        border-width: 1px;
    }
        #qq1{
            margin-left: 250px;
        }
    </style> 
</head>
<script language="javascript">

    function repairSubmit() {
        var fault_detail = $("#fault_detail").val();
        var fault_type = $("#fault_type").val();
        var fault_location = $("#fault_location").val();
        var stu_name = $("#stu_name").val();
        if (fault_detail==""||fault_type==""||fault_location==""||stu_name==""){
            alert("属性不能为空！");
            //return;
        }else
            {
            $.ajax({
                type:'post',
                url:'/StudentView/Stu_new',
                dataType: "json",
                data:{
                    index_detail:fault_detail,
                    index_type:fault_type,
                    index_location:fault_location,
                    index_name:stu_name,},
                success: function (data) {
                    //$("#repositoryControl").load("http://localhost:8088/View/StudentView/Stu_seerepairform.jsp")
                },
                error:function () {
                    //$("#repositoryControl").load("http://localhost:8088/View/StudentView/Stu_seerepairform.jsp")
                    alert("已提交!")
                }
            },JSON)
        }

    }
</script>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-9 column" >
<form autocomplete="on" >
    <fieldset>
        <legend><center>维修表</center></legend>
        <div id="qq">
            <br/><br/>
            <div id="qq1">

        <p>
            <label for="fault_type">故障类型：</label>
            <input type="text" id="fault_type" name="fault_type" tabindex="2" required placeholder="请输入故障类型">*
        </p>
        <p>
            <label for="stu_name">姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名：</label>
            <input type="text" id="stu_name" name="stu_name" tabindex="3" placeholder="请输入用户名">
        </p>
        <p>
            <label for="fault_location">地&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp址：</label>
            <input type="text" id="fault_location" name="fault_location" tabindex="4" required placeholder="请输入维修地址">*
        </p>
        <p>
            <label for="telephone">联系电话：</label>
            <input type="text" id="telephone" name="telephone" tabindex="5" pattern="[0-9]{11}" placeholder="请输入联系电话">
        </p>
        <p>
            <label for="reform_time">报修时间：</label>
            <input type="date" id="reform_time" name="reform_time" tabindex="5">
        </p>
        <p>
        <label for="fault_detail">故障描述：</label>
        <textarea name="fault_detail" id="fault_detail" cols="22" rows="auto" tabindex="1" required placeholder="请输入详细故障描述"></textarea>*
        </p>
        <p id="buttons">
            <input id="reset" type="reset" tabindex="6" size="5">
            <button onclick="repairSubmit()">提交</button>
        </p>
        </div>
            <br/><br/>
        </div>
    </fieldset>
</form>
        </div>
    </div>
</div>
</body>
</html>
