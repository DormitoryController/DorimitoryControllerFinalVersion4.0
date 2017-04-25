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
<table class="table">
    <thead>
    <tr>
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
            状态
        </th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>
            1
        </td>
        <td>
            TB - Monthly
        </td>
        <td>
            01/04/2012
        </td>
        <td>
            Default
        </td>
    </tr>
    <tr class="success">
        <td>
            1
        </td>
        <td>
            TB - Monthly
        </td>
        <td>
            01/04/2012
        </td>
        <td>
            Approved
        </td>
    </tr>
    <tr class="error">
        <td>
            2
        </td>
        <td>
            TB - Monthly
        </td>
        <td>
            02/04/2012
        </td>
        <td>
            Declined
        </td>
    </tr>
    <tr class="warning">
        <td>
            3
        </td>
        <td>
            TB - Monthly
        </td>
        <td>
            03/04/2012
        </td>
        <td>
            Pending
        </td>
    </tr>
    <tr class="info">
        <td>
            4
        </td>
        <td>
            TB - Monthly
        </td>
        <td>
            04/04/2012
        </td>
        <td>
            Call in to confirm
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
