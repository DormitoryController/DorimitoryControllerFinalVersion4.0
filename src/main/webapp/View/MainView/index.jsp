<html>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>

    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>


    <title>Insert title here</title>
</head>
<!--测试过i-->
<script>
    $(document).ready(function welcome() {
        alert("欢迎使用西安交通大学宿舍管理系统")
    })
    function repositoryControl() {
        $("#repositoryControl").load("/MainController/repositoryControl")
    }
    function repositoryInfo() {
        $("#repositoryControl").load("/MainController/repositoryInfo")

    }
    function reword() {
        $("#repositoryControl").load("/MainController/reword")

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
        <div class="col-md-12 column" >
            <div class="carousel slide" id="carousel-883714">
                <ol class="carousel-indicators">
                    <li class="active" data-slide-to="0" data-target="#carousel-883714">
                    </li>
                    <li data-slide-to="1" data-target="#carousel-883714">
                    </li>
                    <li data-slide-to="2" data-target="#carousel-883714">
                    </li>
                </ol>
                <div class="carousel-inner">
                    <div class="item active">
                        <img alt="" src="/CSS/MainCss/Image/xiaohui.jpg" />
                        <div class="carousel-caption">
                            <h4>
                                First Thumbnail label
                            </h4>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                        </div>
                    </div>
                    <div class="item">
                        <img alt="" src="/CSS/MainCss/Image/xiaohui.jpg" />
                        <div class="carousel-caption">
                            <h4>
                                Second Thumbnail label
                            </h4>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                        </div>
                    </div>
                    <div class="item">
                        <img alt="" src="/CSS/MainCss/Image/xiaohui.jpg" />
                        <div class="carousel-caption">
                            <h4>
                                Third Thumbnail label
                            </h4>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                        </div>
                    </div>
                </div> <a class="left carousel-control" href="#carousel-883714" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-883714" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="col-md-2 column">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <p class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-195418" >仓库管理</p>
                    </div>
                    <div id="panel-element-280715" class="panel-collapse collapse" style="display: block">
                        <div class="panel-body" onclick="repositoryControl()">
                            <a  onclick="repositoryControl()">仓库管理 </a>
                        </div>
                        <div class="panel-body" onclick="repositoryInfo()" style="display: block">
                            <a  onclick="repositoryInfo()" >仓库信息</a>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <p class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-195418">查看回执单</p>
                    </div>
                    <div id="panel-element-280714" class="panel-collapse collapse" style="display: block">
                        <div class="panel-body" style="display: block">
                            <a onclick="reword()"> 回执单信息</a>
                        </div>
                    </div>
                </div>
            </div>
              <div class="col-md-6 column">
                  <div id="repositoryControl" ></div>
              </div>
        </div>
    </div>
</div>
</body>
</html>