<html>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>
    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <title>insert tittle here</title>
</head>
<!--测试过i-->
<script>
    $(document).ready(function(){
        $("#pane1").click(function(){
            $("#div1").load("http://localhost:8080/test")
        });
    });
    function repository1() //查看学生信息
    {
        $("#SrepositoryControl").load("/SuperMannagerController/Student")
    }

    function repository2() //查看维修人员信息
    {
        $("#SrepositoryControl").load("/SuperMannagerController/Repairer")
    }

    function repository3() //查看宿舍管理员信息
    {
        $("#SrepositoryControl").load("/SuperMannagerController/Supervisor")
    }

    function repository4()//添加验证码信息
    {
        $("#SrepositoryControl").load("/SuperMannagerController/CheckCode")
    }
    function repository5()//查看学生验证码
    {
        $("#SrepositoryControl").load("/SuperMannagerController/StudentCheckCode")
    }
    function repository6()//查看维修员验证码
    {
        $("#SrepositoryControl").load("/SuperMannagerController/RepairerCheckCode")
    }
    function repository7()//查看宿舍管理员验证码
    {
        $("#SrepositoryControl").load("/SuperMannagerController/SupervisorCheckCode")
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
                        <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-195418" href="#panel-element-280715">人员信息管理</a>
                    </div>
                    <div id="panel-element-280715" class="panel-collapse collapse">
                        <div class="panel-body" onclick="repository1()">
                            <a  onclick="repository1()">学生信息 </a>
                       </div>
                        <div class="panel-body" onclick="repository2()">
                            <a  onclick="repository2()">维修人员信息 </a>
                        </div>
                        <div class="panel-body" onclick="repository3()">
                            <a  onclick="repository3()">宿舍管理员信息 </a>
                        </div>
                        <div class="panel-body" onclick="repository4()">
                            <a  onclick="repository4()">添加验证码信息 </a>
                        </div>
                        <div class="panel-body" onclick="repository5()">
                            <a  onclick="repository5()">查看学生验证码信息 </a>
                        </div>
                        <div class="panel-body" onclick="repository6()">
                            <a  onclick="repository6()">查看维修员验证码信息 </a>
                        </div>
                        <div class="panel-body" onclick="repository7()">
                            <a  onclick="repository7()">查看宿舍管理员验证码信息 </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6 column">
                <div id="SrepositoryControl" ></div>
            </div>
            <%--<table id="mytable"></table>--%>
        </div>
    </div>
</div>
</body>
</html>