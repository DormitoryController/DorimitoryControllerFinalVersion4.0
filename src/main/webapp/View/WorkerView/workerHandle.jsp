<%--
  Created by IntelliJ IDEA.
  User: Administration
  Date: 2017/5/11
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<html>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>
    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <title>报修处理系统</title>
</head>
<script>
    function finish() {
        $("#ArepositoryControl").load("/workerHandleController/finish")
    }
    function deleteOb(id) {
        var myid = id;

            $.ajax({
                type: 'post',
                url: '/workerHandleController/modify',
                dataType: "json",
                data: {index: myid},
                success: function (data) {
                    //alert("删除失败！")
                },
                error: function () {
                    alert("已完成任务！")

                }
            }, JSON)

    }

    var index=0;
    var indexbuff=0;
    $("#document").ready(function () {
        $.ajax({
            type:'post',
            url:'/workerHandleController/handle',
            data:{index:0},
            success: function (data) {
                $("#tbody").empty();
                var result = eval("(" + data + ")");
                var ob = result.handlelist;
                for (var i in ob) {
                    var txt = "<tr>" +
                        "<th>" + ob[i].id+ "</th>" +
                        "<th>" + ob[i].fault_type + "</th>" +
                        "<th>" + ob[i].fault_detail +  "</th>" +
                        "<th>" +ob[i].fault_location+ "</th>" +
                            "<th>" +ob[i].fault_state+ "</th>" +
                        "<th><button buttonid  onclick='deleteOb("+ob[i].id+")'>完成</th>"+
                        "</tr>"
                    $("#tbody").append(txt);
                }
            },
        },JSON)
    })

    function loadInfo(number) {
        indexbuff=index;
        index=number;
        $.ajax({
            type:'post',
            url:'/workerHandleController/handle',
            data:{index:number},
            success: function (data) {
                var result = eval("(" + data + ")");
                var ob = result.handlelist;
                if(ob[0]!=null) {
                    $("#tbody").empty();
                    for (var i in ob) {
                        var txt = "<tr>" +
                            "<th>" + ob[i].id+ "</th>" +
                            "<th>" + ob[i].fault_type + "</th>" +
                            "<th>" + ob[i].fault_detail +  "</th>" +
                            "<th>" +ob[i].fault_location+ "</th>" +
                                "<th>" +ob[i].fault_state+ "</th>" +
                            "<th><button buttonid  onclick='deleteOb("+ob[i].id+")'>完成</th>"+
                            "</tr>"
                        $("#tbody").append(txt);
                    }
                    if(index>1){
                        $("#tfoot").empty();
                        var txt2="<li><a href='#' onclick='prev()'>上一页</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(index-2)+")'>"+(index-1)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(index-1)+")'>"+index+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(index)+")'>"+(index+1)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(index+1)+")'>"+(index+2)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(index+2)+")'>"+(index+3)+"</a></li>"+
                            "<li><a href='#' onclick='next()'>下一页</a></li>"

                        $("#tfoot").append(txt2);
                    }
                    else{
                        $("#tfoot").empty();
                        var txt2="<li><a href='#' onclick='prev()'>上一页</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(0)+")'>"+(1)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(1)+")'>"+2+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(2)+")'>"+(3)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(3)+")'>"+(4)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(4)+")'>"+(5)+"</a></li>"+
                            "<li><a href='#' onclick='next()'>下一页</a></li>"
                        $("#tfoot").append(txt2);
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
                url: '/workerHandleController/handle',
                data: {index: index},
                success: function (data) {
                    $("#tbody").empty();
                    var result = eval("(" + data + ")");
                    var ob = result.handlelist;
                    if(ob[0]!=null) {
                        for (var i in ob) {
                            var txt = "<tr>" +
                                "<th>" + ob[i].id+ "</th>" +
                                "<th>" + ob[i].fault_type + "</th>" +
                                "<th>" + ob[i].fault_detail +  "</th>" +
                                "<th>" +ob[i].fault_location+ "</th>" +
                                    "<th>" +ob[i].fault_state+ "</th>" +
                                "<th><button buttonid  onclick='deleteOb("+ob[i].id+")'>完成</th>"+
                                "</tr>"
                            $("#tbody").append(txt);
                        }
                        if(index>1){
                            $("#tfoot").empty();
                            var txt2="<li><a href='#' onclick='prev()'>上一页</a></li>"+
                                "<li><a href='#' onclick='loadInfo("+(index-2)+")'>"+(index-1)+"</a></li>"+
                                "<li><a href='#' onclick='loadInfo("+(index-1)+")'>"+index+"</a></li>"+
                                "<li><a href='#' onclick='loadInfo("+(index)+")'>"+(index+1)+"</a></li>"+
                                "<li><a href='#' onclick='loadInfo("+(index+1)+")'>"+(index+2)+"</a></li>"+
                                "<li><a href='#' onclick='loadInfo("+(index+2)+")'>"+(index+3)+"</a></li>"+
                                "<li><a href='#' onclick='next()'>下一页</a></li>"
                            $("#tfoot").append(txt2);
                        }
                        else{
                            $("#tfoot").empty();
                            var txt2="<li><a href='#' onclick='prev()'>上一页</a></li>"+
                                "<li><a href='#' onclick='loadInfo("+(0)+")'>"+(1)+"</a></li>"+
                                "<li><a href='#' onclick='loadInfo("+(1)+")'>"+2+"</a></li>"+
                                "<li><a href='#' onclick='loadInfo("+(2)+")'>"+(3)+"</a></li>"+
                                "<li><a href='#' onclick='loadInfo("+(3)+")'>"+(4)+"</a></li>"+
                                "<li><a href='#' onclick='loadInfo("+(4)+")'>"+(5)+"</a></li>"+
                                "<li><a href='#' onclick='next()'>下一页</a></li>"
                            $("#tfoot").append(txt2);
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
            url: '/workerHandleController/handle',
            data: {index: index},
            success: function (data) {
                var result = eval("(" + data + ")");
                var ob = result.handlelist;
                if (ob[0]!=null) {
                    $("#tbody").empty();
                    for (var i = 0; i < 5; i++) {
                        var txt = "<tr>" +
                            "<th>" + ob[i].id+ "</th>" +
                            "<th>" + ob[i].fault_type + "</th>" +
                            "<th>" + ob[i].fault_detail +  "</th>" +
                            "<th>" +ob[i].fault_location+ "</th>" +
                                "<th>" +ob[i].fault_state+ "</th>" +
                            "<th><button buttonid  onclick='deleteOb("+ob[i].id+")'>完成</th>"+
                            "</tr>"
                        $("#tbody").append(txt);
                    }
                    if(index>1){
                        $("#tfoot").empty();
                        var txt2="<li><a href='#' onclick='prev()'>上一页</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(index-2)+")'>"+(index-1)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(index-1)+")'>"+index+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(index)+")'>"+(index+1)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(index+1)+")'>"+(index+2)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(index+2)+")'>"+(index+3)+"</a></li>"+
                            "<li><a href='#' onclick='next()'>下一页</a></li>"
                        $("#tfoot").append(txt2);
                    }
                    else{
                        $("#tfoot").empty();
                        var txt2="<li><a href='#' onclick='prev()'>上一页</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(0)+")'>"+(1)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(1)+")'>"+2+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(2)+")'>"+(3)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(3)+")'>"+(4)+"</a></li>"+
                            "<li><a href='#' onclick='loadInfo("+(4)+")'>"+(5)+"</a></li>"+
                            "<li><a href='#' onclick='next()'>下一页</a></li>"
                        $("#tfoot").append(txt2);
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
</script>
<style>
    body {
        background-color: #d9edf7;
    }
    #workerhandle{
        width: 995px;
        margin-left: -45px;
    }
</style>
<body>
<div class="container" id="workerhandle">
    <div class="row clearfix" align="center">
        <div class="col-md-12 column">
            <div class="jumbotron well">
            <table class="table">
                <thead>
                <tr id="th1">
                    <th id="df">编号</th>
                    <th>故障的设施</th>
                    <th>详细信息</th>
                    <th>故障地点</th>
                    <th id="deee">状态</th>
                    <th>完成任务</th>
                </tr>
                </thead>
                <tbody id="tbody">
              <%--  <tr class="error">
                    <td>2</td>
                    <td>TB - Monthly</td>
                    <td>02/04/2012</td>
                    <td>Declined</td>
                    <td><button type="button" class="btn btn-default">完成</button></td>
                </tr>
                <tr class="error">
                    <td>4</td>
                    <td>TB - Monthly</td>
                    <td>02/04/2013</td>
                    <td>Declcdcvined</td>
                    <td><button type="button" class="btn btn-default">完成</button></td>
                </tr>--%>
                </tbody>
            </table>
                <div class="row clearfix" align="center">
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

</div>
<%--<div class="col-md-6 column">
    <div id="ArepositoryControl" ></div>
</div>--%>
</body>
</html>
