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
     $(document).ready(function(){


    });
     function btn() {
         $("#div1").load("http://localhost:8001/")
     }
</script>
<body>
<button id="bt1" onclick="btn()">btn1</button>
<div id="div1"/>
</body>
</html>
