<%--
  Created by IntelliJ IDEA.
  User: 李朋辉
  Date: 2017/4/25
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>
    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>


    <title>宿管</title>
</head>
<!--测试过i-->
<script>
    function maintenanceControl() {
        $("#maintenanceControl").load("http://localhost:8001/DormManage/maintenanceControl")
    }
    function updateInfoControl() {
        $("#maintenanceControl").load("http://localhost:8001/DormManage/updateInfoControl")
    }
</script>
</head>
<style>body {
    background-color: #d9edf7;
}
</style>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="carousel slide" id="carousel-883715">
                <ol class="carousel-indicators">
                    <li class="active" data-slide-to="0" data-target="#carousel-883715">
                    </li>
                    <li data-slide-to="1" data-target="#carousel-883715">
                    </li>
                    <li data-slide-to="2" data-target="#carousel-883715">
                    </li>
                </ol>
                <div class="carousel-inner">
                    <div class="item active">
                        <img alt="" src="/CSS/MainCss/Image/xiaohui.jpg"/>
                        <div class="carousel-caption">
                            <h4>
                                First Thumbnail label
                            </h4>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta
                                gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                        </div>
                    </div>
                    <div class="item">
                        <img alt="" src="/CSS/MainCss/Image/xiaohui.jpg"/>
                        <div class="carousel-caption">
                            <h4>
                                Second Thumbnail label
                            </h4>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta
                                gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                        </div>
                    </div>
                    <div class="item">
                        <img alt="" src="/CSS/MainCss/Image/xiaohui.jpg"/>
                        <div class="carousel-caption">
                            <h4>
                                Third Thumbnail label
                            </h4>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta
                                gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                        </div>
                    </div>
                </div>
                <a class="left carousel-control" href="#carousel-883715" data-slide="prev"><span
                        class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control"
                                                                                href="#carousel-883715"
                                                                                data-slide="next"><span
                    class="glyphicon glyphicon-chevron-right"></span></a>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row container-fluid">
            <div class="col-md-12 column ">
                <div class="col-md-2 column">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-195419"
                               href="#panel-element-280717">维修管理</a>
                        </div>
                        <div id="panel-element-280717" class="panel-collapse collapse">
                            <div class="panel-body" onclick="maintenanceControl()">
                                <a onclick="maintenanceControl()">维修安排</a>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-195419"
                               href="#panel-element-280722">个人中心</a>
                        </div>
                        <div id="panel-element-280722" class="panel-collapse collapse">
                            <div class="panel-body" onclick="updateInfoControl()">
                                <a onclick="updateInfoControl()">个人信息</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-9 column">
                    <div id="maintenanceControl"></div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
