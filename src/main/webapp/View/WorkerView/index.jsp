<html>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>
    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
  <%--  <LINK href="/CSS/WorkerCss/css/Style.css" type=text/css rel=stylesheet>--%>
    <title>报修处理系统</title>
</head>
<!--测试过i-->
<script>
    $(document).ready(function(){
        $("#pane1").click(function(){
            $("#div1").load("/workerHandleController/test")
        });
    });
    function workerHandle() {

        $("#ArepositoryControl").load("/workerHandleController/workerHandle")
    }
    function workerHistory() {

        $("#ArepositoryControl").load("/workerHandleController/workerHistory")
    }
    function workerReply() {
        $("#ArepositoryControl").load("/workerHandleController/worker1")
    }
    function workerLookPerson() {
        $("#ArepositoryControl").load("/workerHandleController/workerModel2")
    }
    function workerModifyPerson() {
        $("#ArepositoryControl").load("/workerHandleController/workerModel")
    }


</script>
</head>
<style>
    body {
   background-color: #d9edf7;
}
    #welcome{
        width: 995px;
    }
    #col{
        margin-left: -45px;
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
                        <img alt="" src="/CSS/MainCss/Image/xiaohui.jpg"style="width: 100%;height: 30%" />
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
                </div>
                <a class="left carousel-control" href="#carousel-883714" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                </a>
                <a class="right carousel-control" href="#carousel-883714" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                </a>
            </div>
        </div>
    </div>


    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="col-md-2 column">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-195418" href="#panel-element-280715">
                            <font size="5"style="font-weight: bold">功能菜单</font>
                        </a>
                    </div>
                    <div id="panel-element-280715" class="panel-collapse collapse">
                        <div class="panel-body" onclick="workerHandle()">
                            <a  onclick="workerHandle()">待处理的维修 </a>
                        </div>
                        <div class="panel-body" onclick="workerHistory()">
                            <a  onclick="workerHistory()">查看维修记录 </a>
                        </div>
                        <div class="panel-body" onclick="workerReply()">
                            <a  onclick="workerReply()">填写回执单 </a>
                        </div>
                        <div class="panel-body" onclick="workerLookPerson()">
                            <a  onclick="workerLookPerson()">查看个人信息 </a>
                        </div>
                        <div class="panel-body" onclick="workerModifyPerson()">
                            <a  onclick="workerModifyPerson()">修改个人信息 </a>
                        </div>
                    </div>
                </div>



            </div>

            <div class="col-md-6 column">
                <div id="ArepositoryControl" ></div>
            </div>
        </div>

    </div>

    </div>


</body>
</html>