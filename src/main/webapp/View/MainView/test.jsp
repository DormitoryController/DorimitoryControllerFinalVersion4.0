<%--
  Created by IntelliJ IDEA.
  User: 赵嗣瑜
  Date: 2017/4/24
  Time: 23:51
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
</head>
<script>
//    $(document).ready(function(){
//        $("button").click(function(){
//            $.post("http://localhost:8001/user",{
//                    name:"菜鸟教程",
//                    url:"http://www.runoob.com"
//                },
//                function(data,status){
//                    alert("数据: \n" + data.getId() + "\n状态: " + status);
//                });
//        });
//    });
$(function () {
    $('#btn1').click(function () {
        $.ajax({
            type:'post',
            url:'/MainController/user',
            data:{param:'就是我'},
            success: function (data) {
                var result=eval("("+data+")");
                var ob=result.userlist;
               for(var i in ob)
                   alert(ob[i].sex);
            },
            error: function () {
                alert("服务器连接异常");
            }
        },JSON)
    });
});
</script>
<body>
<button id="btn1" >发送一个 HTTP POST 请求页面并获取返回内容</button>
<form action="">
</body>
</html>
