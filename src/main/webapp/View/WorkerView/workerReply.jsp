<%--
  Created by IntelliJ IDEA.
  User: Administration
  Date: 2017/5/11
  Time: 21:17
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
    var index=0;
    var index=0;
    var indexbuff=0;
    function look(id) {
        var myid = id;
        var commit = $("#reason").val();
        var commit1 = $("#reform_time1").val();
            $.ajax({
                type: 'post',
                url: '/workerHandleController/detailReply1',
                dataType: "json",
                data: {index: myid,
                index1:commit,
                index2:commit1,
                },
                success: function (data) {
                    alert("ch")
                    $("#ArepositoryControl").load("http://localhost:8080/View/WorkerView/detailReply.jsp")
                },
                error: function () {
                    alert("提交成功！")
                }
            }, JSON)
    }

    $("#document").ready(function () {
        $.ajax({
            type:'post',
            url:'/workerHandleController/reply',
            data:{index:0},
            success: function (data) {
                $("#tbody").empty();
                var result = eval("(" + data + ")");
                var ob = result.handlelist;
                var datelist=result.datelist;
                for (var i in ob) {
                    var txt = "<tr>" +
                        "<th>" + ob[i].id + "</th>" +
                        "<th>" + ob[i].fault_type + "</th>" +
                            "<th>" + datelist[i]+ "</th>" +
                        "<th>" + ob[i].fault_location + "</th>" +
                        "<th><input id='reason' type='text'></th>" +
                        "<th> <input type='date' id='reform_time1' tabindex='5'></th>" +
                        "<th><button buttonid onclick='look("+ob[i].id+")'>提交</th>"+
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
            url:'/workerHandleController/reply',
            data:{index:number},
            success: function (data) {
                var result = eval("(" + data + ")");
                var ob = result.handlelist;
                var datelist=result.datelist;
                if(ob[0]!=null) {
                    $("#tbody").empty();
                    for (var i in ob) {
                        var txt = "<tr>" +
                            "<th>" + ob[i].id + "</th>" +
                                "<th>" + ob[i].fault_type + "</th>" +
                                "<th>" +  datelist[i]+ "</th>" +
                            "<th>" + ob[i].fault_location + "</th>" +
                            "<th><input id='reason' type='text'></th>" +
                            "<th> <input type='date' id='reform_time1' tabindex='5'></th>" +
                            "<th><button buttonid onclick='look("+ob[i].id+")'>提交</th>"+
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
                url: '/workerHandleController/reply',
                data: {index: index},
                success: function (data) {
                    $("#tbody").empty();
                    var result = eval("(" + data + ")");
                    var ob = result.handlelist;
                    var datelist=result.datelist;
                    if(ob[0]!=null) {
                        for (var i in ob) {
                            var txt = "<tr>" +
                                "<th>" + ob[i].id + "</th>" +
                                    "<th>" + ob[i].fault_type + "</th>" +
                                    "<th>" + datelist[i] + "</th>" +
                                "<th>" + ob[i].fault_location + "</th>" +
                                "<th><input id='reason' type='text'></th>" +
                                "<th> <input type='date' id='reform_time1' tabindex='5'></th>" +
                                "<th><button buttonid onclick='look("+ob[i].id+")'>提交</th>"+
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
            url: '/workerHandleController/reply',
            data: {index: index},
            success: function (data) {
                var result = eval("(" + data + ")");
                var ob = result.handlelist;
                var datelist=result.datelist;
                if (ob[0]!=null) {
                    $("#tbody").empty();
                    for (var i = 0; i < 5; i++) {
                        var txt = "<tr>" +
                            "<th>" + ob[i].id + "</th>" +
                                "<th>" + ob[i].fault_type + "</th>" +
                                "<th>" + datelist[i]+ "</th>" +
                                "<th>" + ob[i].fault_location + "</th>" +
                                "<th><input id='reason' type='text'></th>" +
                            "<th> <input type='date' id='reform_time1' tabindex='5'></th>" +
                            "<th><button buttonid onclick='look("+ob[i].id+")'>提交</th>"+
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
    #workerhistory{
        width: 995px;
        margin-left: -45px;
    }
</style>
<body>
<div class="container" id="workerhistory">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="jumbotron well">
                <table class="table">
                    <thead>
                    <tr>
                        <p>回执单</p>
                    </tr>
                    <tr id="th1">
                        <th>编号</th>
                        <th>维修类型</th>
                        <th>报修时间</th>
                        <th>维修地点</th>

                        <th>损坏原因</th>
                        <th>日期</th>



                    </tr>
                    </thead>
                    <tbody id="tbody">

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
<div class="col-md-6 column">
    <div id="ArepositoryControl" ></div>
</div>
</body>
</html>
