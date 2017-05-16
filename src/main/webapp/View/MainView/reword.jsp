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
    var index=0;
    var indexbuff=0;
    $("#document").ready(function () {
        $.ajax({
            type:'post',
            url:'/MainController/checkReword',
            data:{index:0},
            success: function (data) {
                $("#rewordBody").empty();
                var result = eval("(" + data + ")");
                var repairerlist = result.repairerlist;
                var maintenanceslist=result.maintenanceslist;
                for (var i in maintenanceslist) {
                    var txt = "<tr><th>" + maintenanceslist[i].id+"</th><th>" + repairerlist[i].name+"</th><th>"+result.date[i]+"</th><th><a onclick='maintenancesDetail("+maintenanceslist[i].id+")'>查看详情</th></tr>"
                    $("#rewordBody").append(txt);
                }
            },
        },JSON)
    })
    function loadInfo(number) {
        indexbuff=index;
        index=number;
        $.ajax({
            type:'post',
            url:'/MainController/checkReword',
            data:{index:number},
            success: function (data) {
                var result = eval("(" + data + ")");
                var repairerlist = result.repairerlist;
                var maintenanceslist=result.maintenanceslist;
                if(maintenanceslist[0]!=null) {
                    $("#rewordBody").empty();
                    for (var i in maintenanceslist) {
                        var txt = "<tr><th>" + maintenanceslist[i].id+"</th><th>" + repairerlist[i].name+"</th><th>"+result.date[i]+"</th><th><a onclick='maintenancesDetail("+maintenanceslist[i].id+")'>查看详情</th></tr>"
                        $("#rewordBody").append(txt);
                    }
                    if(index>1){
                        $("#rewordfoot").empty();
                        var txt2="<li><a href='#' onclick='prev()'>上一页</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(index-2)+")'>"+(index-1)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(index-1)+")'>"+index+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(index)+")'>"+(index+1)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(index+1)+")'>"+(index+2)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(index+2)+")'>"+(index+3)+"</a></li>"+
                            "<li><a href='#' onclick='next()'>下一页</a></li>"

                        $("#rewordfoot").append(txt2);
                    }
                    else{
                        $("#rewordfoot").empty();
                        var txt2="<li><a href='#' onclick='prev()'>上一页</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(0)+")'>"+(1)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(1)+")'>"+2+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(2)+")'>"+(3)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(3)+")'>"+(4)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(4)+")'>"+(5)+"</a></li>"+
                            "<li><a href='#' onclick='next()'>下一页</a></li>"

                        $("#rewordfoot").append(txt2);
                    }

                    indexbuff=index;
                }
                else {
                    alert("暂无更多数据")
                    index=indexbuff;
                }
            },
            error: function () {
                alert("服务器连接异常");
            }
        },JSON)

    }
    function prev() {
        indexbuff=index;
        if(index>0) {
            index=index-1;
            $.ajax({
                type: 'post',
                url: '/MainController/checkReword',
                data: {index: index},
                success: function (data) {
                    $("#rewordBody").empty();
                    var result = eval("(" + data + ")");
                    var repairerlist = result.repairerlist;
                    var maintenanceslist=result.maintenanceslist;
                    if(maintenanceslist[0]!=null) {
                        $("#rewordBody").empty();
                        for (var i in maintenanceslist) {
                            var txt = "<tr><th>" + maintenanceslist[i].id+"</th><th>" + repairerlist[i].name+"</th><th>"+result.date[i]+"</th><th><a onclick='maintenancesDetail("+maintenanceslist[i].id+")'>查看详情</th></tr>"
                            $("#rewordBody").append(txt);
                        }
                        if(index>1){
                            $("#rewordfoot").empty();
                            var txt2="<li><a href='#' onclick='prev()'>上一页</a></li>"+
                                "<li><a href='#' onclick='loadInfo("+(index-2)+")'>"+(index-1)+"</a></li>"+
                                "<li><a href='#' onclick='loadInfo("+(index-1)+")'>"+index+"</a></li>"+
                                "<li><a href='#' onclick='loadInfo("+(index)+")'>"+(index+1)+"</a></li>"+
                                "<li><a href='#' onclick='loadInfo("+(index+1)+")'>"+(index+2)+"</a></li>"+
                                "<li><a href='#' onclick='loadInfo("+(index+2)+")'>"+(index+3)+"</a></li>"+
                                "<li><a href='#' onclick='next()'>下一页</a></li>"

                            $("#rewordfoot").append(txt2);
                        }
                        else{
                            $("#rewordfoot").empty();
                            var txt2="<li><a href='#' onclick='prev()'>上一页</a></li>"+
                                "<li><a href='#' onclick='loadInfo("+(0)+")'>"+(1)+"</a></li>"+
                                "<li><a href='#' onclick='loadInfo("+(1)+")'>"+2+"</a></li>"+
                                "<li><a href='#' onclick='loadInfo("+(2)+")'>"+(3)+"</a></li>"+
                                "<li><a href='#' onclick='loadInfo("+(3)+")'>"+(4)+"</a></li>"+
                                "<li><a href='#' onclick='loadInfo("+(4)+")'>"+(5)+"</a></li>"+
                                "<li><a href='#' onclick='next()'>下一页</a></li>"

                            $("#rewordfoot").append(txt2);
                        }
                        indexbuff=index;
                    }

                    else{
                        alert("暂无更多数据")
                        index=indexbuff;
                    }
                },
                error: function () {
                    alert("服务器连接异常");
                }
            }, JSON)
        }

    }
    function next() {
        indexbuff=index;
        index=index+1;
        $.ajax({
            type: 'post',
            url: '/MainController/checkReword',
            data: {index: index},
            success: function (data) {
                var result = eval("(" + data + ")");
                var repairerlist = result.repairerlist;
                var maintenanceslist=result.maintenanceslist;
                if (maintenanceslist [0]!=null) {
                    $("#rewordBody").empty();
                    for (var i in maintenanceslist) {
                        var txt = "<tr><th>" + maintenanceslist[i].id+"</th><th>" + repairerlist[i].name+"</th><th>"+result.date[i]+"</th><th><a onclick='maintenancesDetail("+maintenanceslist[i].id+")'>查看详情</th></tr>"
                        $("#rewordBody").append(txt);
                    }
                    if(index>1){
                        $("#rewordfoot").empty();
                        var txt2="<li><a href='#' onclick='prev()'>上一页</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(index-2)+")'>"+(index-1)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(index-1)+")'>"+index+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(index)+")'>"+(index+1)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(index+1)+")'>"+(index+2)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(index+2)+")'>"+(index+3)+"</a></li>"+
                            "<li><a href='#' onclick='next()'>下一页</a></li>"

                        $("#rewordfoot").append(txt2);
                    }
                    else{
                        $("#rewordfoot").empty();
                        var txt2="<li><a href='#' onclick='prev()'>上一页</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(0)+")'>"+(1)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(1)+")'>"+2+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(2)+")'>"+(3)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(3)+")'>"+(4)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(4)+")'>"+(5)+"</a></li>"+
                            "<li><a href='#' onclick='next()'>下一页</a></li>"

                        $("#rewordfoot").append(txt2);
                    }
                    indexbuff=index;
                }
                else {
                    alert("暂无更多数据")
                    index=indexbuff;
                    return false;
                }
            },
            error: function () {
                alert("服务器连接异常");
                return false
            }
        }, JSON)
    }
    function maintenancesDetail(id) {
        $.ajax({
            type:'post',
            url:'/MainController/maintanancesIdSet',
            data:{maintananceId:id},
            success: function (data) {
            },error:function () {
                alert("读取数据失败")
            }
        },JSON)
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
                    <ul class="pagination" id="rewordfoot">
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
