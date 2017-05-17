<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/15
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">

    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>

    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

    <style>body {
        background-color: #d9edf7;
    }
    </style>
    <title>个人中心</title>
</head>
<script language="javascript">

    $("#document").ready(function () {
        $.ajax({
            type:'get',
            url:'/StudentView/Stu_selfInf',

            //dataType : "json",
            data:{index:0},
            success: function (data) {
                $("#tbody").empty();
                var result = eval("(" + data + ")");
                var ob = result.list;
                for(i in ob) {
                    var txt = "<tr>" +
                        "<th id='th1'>" + ob[i].id + "</th>"+
                        "<th>" + ob[i].name + "</th>" +
                        "<th>" + ob[i].flatnum + "</th>" +
                        "<th>" + ob[i].dormnum + "</th>" +
                        "<th>" + ob[i].telephone + "</th>" +
                        "<th>" + ob[i].email + "</th>" +
                        "</tr>"
                    $("#tbody").append(txt);
                }
            },
        },JSON)
    })

    function Stu_UpselInf(){
        //alert("请更新个人信息！")
        location.href="/View/StudentView/Stu_persionUp.jsp"
    }

</script>
<body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-9 column" >
                <table cellspacing="0" cellpadding="0">
                    <br>
                    <tr><p align="center">您的个人信息如下：</p></tr>

                        <th id="th1">用户ID:&nbsp;&nbsp;&nbsp;&nbsp;</th>
                        <th id="th2">名字:  &nbsp;&nbsp; &nbsp;&nbsp;   </th>
                        <th id="th3">宿舍楼:  &nbsp;&nbsp; &nbsp;&nbsp; </th>
                        <th id="th4">宿舍号: &nbsp;&nbsp;&nbsp;&nbsp;   </th>
                        <th id="th5">电话:    &nbsp;&nbsp;&nbsp;&nbsp;  </th>
                        <th id="th6">邮箱:   &nbsp;&nbsp;&nbsp;&nbsp;   </th>

                    <tbody id="tbody">

                    </tbody>
                    <%--<button onclick='Stu_UpselInf()'>修改个人信息</button>--%>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
