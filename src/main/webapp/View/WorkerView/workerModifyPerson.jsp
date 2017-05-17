<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/17
  Time: 20:21
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

    function Rer_Submit() {
        var name = $("#name").val();
        var flatnum = $("#flatnum").val();
        var telephone = $("#telephone").val();
        var email = $("#email").val();
        //alert(name+flatnum+telephone+email)
        $.ajax({
            type:'get',
            url:'/workerHandleController/workerModifyPerson',
            dataType: "json",
            data:{
                //index_username:username,
                index_name:name,
                index_flatnum:flatnum,
                index_telephone:telephone,
                index_email:email,},
            success: function (data) {
                //$("#repositoryControl").load("http://localhost:8088/View/StudentView/Stu_seerepairform.jsp")
            },
            error:function () {
                //$("#repositoryControl").load("http://localhost:8088/View/StudentView/Stu_seerepairform.jsp")
                alert("修改信息成功!")
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
                    <legend><center>更改信息</center></legend>
                    <div id="qq">
                        <br/><br/>
                        <div id="qq1">

                            <p>
                                <label for="name">姓名：</label>
                               &nbsp;&nbsp; &nbsp;&nbsp;  <input type="text" id="name" name="name" tabindex="2"  placeholder="请输入姓名">*
                            </p>
                            <p>
                                <label for="flatnum">办公地点：</label>
                                <input type="text" id="flatnum" name="flatnum" tabindex="3" placeholder="请输入办公地点">
                            </p>
                            <p>
                                <label for="telephone">联系电话：</label>
                                <input type="text" id="telephone" name="telephone" tabindex="3" pattern="[0-9]{11}"   placeholder="请输入联系电话">
                            </p>
                            <p>
                                <label for="email">邮箱：</label>
                                &nbsp;&nbsp;  &nbsp;&nbsp;<input type="text" id="email" name="email" tabindex="4" placeholder="请输入邮箱">*
                            </p>

                            <p id="buttons">
                                &nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;
                                <button onclick="Rer_Submit()">修改</button>
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
