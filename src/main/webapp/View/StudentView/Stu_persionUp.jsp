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

    function Stu_Submit() {
        var name = $("#name").val();
        var flatnum = $("#flatnum").val();
        var dormnum = $("#dormnum").val();
        var telephone = $("#telephone").val();
        var email = $("#email").val();
        $.ajax({
            type:'post',
            url:'/StudentView/Stu_upStu',
            dataType: "json",
            data:{
                //index_username:username,
                index_name:name,
                index_flatnum:flatnum,
                index_dormnum:dormnum,
                index_telephone:telephone,
                index_email:email,},
            success: function (data) {
                //$("#repositoryControl").load("http://localhost:8088/View/StudentView/Stu_seerepairform.jsp")
            },
            error:function () {
                //$("#repositoryControl").load("http://localhost:8088/View/StudentView/Stu_seerepairform.jsp")
                alert("已更新!")
            }
        },JSON)

    }
</script>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-9 column" >
            <form autocomplete="on" >
                <fieldset>
                    <legend><center>个人信息</center></legend>
                    <div id="qq">
                        <br/><br/>
                        <div id="qq1">

                            <p>
                                <label for="name">名字：</label>
                                <input type="text" id="name" name="name" tabindex="2"  placeholder="请输入名字">*
                            </p>
                            <p>
                                <label for="flatnum">楼号：</label>
                                <input type="text" id="flatnum" name="flatnum" tabindex="3" placeholder="请输入宿舍楼">
                            </p>
                            <p>
                                <label for="dormnum">房号：</label>
                                <input type="text" id="dormnum" name="dormnum" tabindex="3" placeholder="请输入宿舍号">
                            </p>
                            <p>
                                <label for="telephone">电话：</label>
                                <input type="text" id="telephone" name="telephone" tabindex="4" pattern="[0-9]{11}"  placeholder="请输入电话">*
                            </p>
                            <p>
                                <label for="email">邮箱：</label>
                                <input type="text" id="email" name="email" tabindex="5" placeholder="请输入邮箱">
                            </p>

                            <p id="buttons">
                                <button onclick="Stu_Submit()">更新信息</button>
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
