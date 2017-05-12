<%--
  Created by IntelliJ IDEA.
  User: 赵嗣瑜
  Date: 2017/4/20
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>

    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>


</head>
<script>
    $(document).ready()
    {
    }
    function test() {
        $.post("/MainController/user", function (data, status) {
            var list = data.getElementsByTagName("userlist")
            $("#table2").append(list);
        })
    }
</script>
<body >
<table id="table" class="table1" >
    <tr>
        <td >
            <button onclick="test()">test</button>
        </td>
    </tr>
</table>
<div id="table2"></div>
</body>
</html>
