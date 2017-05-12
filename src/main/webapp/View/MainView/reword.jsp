<%--
  Created by IntelliJ IDEA.
  User: 赵嗣瑜
  Date: 2017/5/11
  Time: 0:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>reword</title>
</head>
<script>
    $("#document").ready(function () {
        $.ajax({
            type:'post',
            url:'/MainController/checkReword',
            data:{index:0},
            success: function (data) {
                $("#tbody").empty();
                var result = eval("(" + data + ")");
                var repairerlist = result.repairerlist;
                var maintenanceslist=result.maintenanceslist;
                for (var i in maintenanceslist) {
                    var txt = "<tr><th>" + maintenanceslist[i].id+"</th><th>" + repairerlist[i].name+"</th><th>"+maintenanceslist[i].response_time+"</th><th><a onclick='maintenancesDetail("+maintenanceslist[i].id+")'>查看详情</th></tr>"
                    $("#rewordBody").append(txt);
                }
            },
        },JSON)
    })
    function maintenancesDetail(id) {
        $("#repositoryControl").load("/MainController/maintanancesDetail");
    }

</script>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr>
                    <th id="th1">
                        编号
                    </th>
                    <th>
                        维修人员
                    </th>
                    <th>
                        维修时间
                    </th>
                    <th>

                    </th>
                </tr>
                </thead>
                <tbody id="rewordBody">

                </tbody>
            </table>
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <ul class="pagination" id="tfoot">
                        <li>
                            <a href="#" onclick="prev()">上一页</a>
                        </li>
                        <li>
                            <a href="#" onclick=" loadInfo(0)">1</a>
                        </li>
                        <li>
                            <a href="#" onclick=" loadInfo(1)">2</a>
                        </li>
                        <li>
                            <a href="#" onclick=" loadInfo(2)">3</a>
                        </li>
                        <li>
                            <a href="#" onclick=" loadInfo(3)">4</a>
                        </li>
                        <li>
                            <a href="#" onclick=" loadInfo(4)">5</a>
                        </li>
                        <li>
                            <a href="#" onclick="next()">下一页</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
