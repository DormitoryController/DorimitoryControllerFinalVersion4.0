
<%--
  Created by IntelliJ IDEA.
  User: 庞博
  Date: 2017/4/25
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Student</title>
    <meta charset="UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>
    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>
<style>
    body {
        background-color: #d9edf7;
    }
</style>
<script>
    var index=0;
    var indexbuff=0;
    $("#document").ready(function () {
        $.ajax({
            type:'post',
            url:'/SuperMannagerController/StudentCheckCodeItem',
            data:{index:0},
            success: function (data) {
                $("#tbody").empty();
                var result = eval("(" + data + ")");
                var ob = result.student_checkcode_item_list;
                for (var i in ob) {
                    var txt =  "<tr>" +
//                            "<th>" + ob[i].id+"</th>" +
                            "<th>" + ob[i].user_id+"</th>" +
                            "<th>" + ob[i].checkcode+"</th>" +
                            "<th>" + ob[i].user_type+"</th>" +
                            "<th>" + ob[i].use_state+"</th>" +
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
            url:'/SuperMannagerController/StudentCheckCodeItem',
            data:{index:number},
            success: function (data) {
                var result = eval("(" + data + ")");
                var ob = result.student_checkcode_item_list;
                if(ob[0]!=null) {
                    $("#tbody").empty();
                    for (var i in ob) {
                        var txt =  "<tr >" +
//                                "<th>" + ob[i].id+"</th>" +
                                "<th>" + ob[i].user_id+"</th>" +
                                "<th>" + ob[i].checkcode+"</th>" +
                                "<th>" + ob[i].user_type+"</th>" +
                                "<th>" + ob[i].use_state+"</th>" +
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
                url: '/SuperMannagerController/StudentCheckCodeItem',
                data: {index: index},
                success: function (data) {
                    $("#tbody").empty();
                    var result = eval("(" + data + ")");
                    var ob = result.student_checkcode_item_list;
                    if(ob[0]!=null) {
                        for (var i in ob) {
                            var txt =  "<tr >" +
//                                    "<th>" + ob[i].id+"</th>" +
                                    "<th>" + ob[i].user_id+"</th>" +
                                    "<th>" + ob[i].checkcode+"</th>" +
                                    "<th>" + ob[i].user_type+"</th>" +
                                    "<th>" + ob[i].use_state+"</th>" +
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
            url: '/SuperMannagerController/StudentCheckCodeItem',
            data: {index: index},
            success: function (data) {
                var result = eval("(" + data + ")");
                var ob = result.student_checkcode_item_list;
                if (ob[0]!=null) {
                    $("#tbody").empty();
                    for (var i = 0; i < 5; i++) {
                        var txt =  "<tr >" +
//                                "<th>" + ob[i].id+"</th>" +
                                "<th>" + ob[i].user_id+"</th>" +
                                "<th>" + ob[i].checkcode+"</th>" +
                                "<th>" + ob[i].user_type+"</th>" +
                                "<th>" + ob[i].use_state+"</th>" +
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
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr>
                    <th>
                        用户ID
                    </th>
                    <th>
                        校验码
                    </th>
                    <th>
                       用户类型
                    </th>
                    <th>
                        用户状态
                    </th>
                </tr>
                </thead>
                <tbody id="tbody">

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
