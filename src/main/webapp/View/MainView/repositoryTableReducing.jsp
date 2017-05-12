<%--
  Created by IntelliJ IDEA.
  User: 赵嗣瑜
  Date: 2017/4/25
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>repositoryTable</title>
    <meta charset="UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>

    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>
<body>
<style>body {
    background-color: #d9edf7;
}
</style>
<script>
    var index=1;
    $(document).ready(function repositoryReducing() {
        $.ajax({
            type:'post',
            url:'/MainController/repositoryItem',
            data:{index:0},
            success: function (data) {
                var txt1="";
                var result = eval("(" + data + ")");
                var ob = result.itemlist;
                for (var i in ob) {
                    txt1=txt1+"<option value='"+ob[i].name+"'>"+ob[i].name+"</option>"
                }
                var txt2="<tr><td>"+index+"</td>" +
                    "<td><select style='background-color: #d9edf7'> "+txt1+
                    "<td>01/04/2012 </td>" +
                    "<td><input type='number'style='background-color: #d9edf7'></td>" +
                    "<td onclick='addColumn()'> <a>+</a> </td>"
                "</tr>";
                $("#table2").append(txt2);
                index++;
            },
        },JSON)
    })
    function addColumn() {
        $.ajax({
            type:'post',
            url:'/MainController/repositoryItem',
            data:{index:0},
            success: function (data) {
                var txt1="";
                var result = eval("(" + data + ")");
                var ob = result.itemlist;
                for (var i in ob) {
                   txt1=txt1+"<option value='"+ob[i].name+"'>"+ob[i].name+"</option>"
                }
                var txt2="<tr><td>"+index+"</td>" +
                    "<td><select style='background-color: #d9edf7'> "+txt1+
                    "<td>01/04/2012 </td>" +
                    "<td><input type='number'style='background-color: #d9edf7'></td>" +
                    "<td onclick='addColumn()'> <a>+</a> </td>"
                "</tr>";
                $("#table2").append(txt2);
                index++;
            },
        },JSON)
    }
    function ItemSubmit() {
        $.ajax({
            type:'post',
            url:'/MainController/itemSubmit',
            data:{index:0},
            success: function (data) {
               alert("提交成功")
            },
            error:function () {
                alter("服务器异常，提交失败")
            }

        },JSON)

    }
</script>
<table class="table"  >
    <thead>
    <tr class="info">
        <th>
            编号
        </th>
        <th>
            产品
        </th>
        <th>
            交付时间
        </th>
        <th>
            数量
        </th>
        <th>

        </th>
    </tr>
    </thead>
    <tbody   id="table2">


    </tbody>
    <tfoot>
    <tr class="info">
        <td>
            <button type="submit"name="submit" style="background-color: #d9edf7" onclick="ItemSubmit()">提交修改</button>
        </td>
    </tr>
    </tfoot>
</table>
</body>
</html>
