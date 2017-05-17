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
    function maintenanceControl() {
        $("#repositoryControl").load("/DormManage/maintenanceControl")
    }
    function updateInfoControl() {
        $("#repositoryControl").load("/DormManage/updateInfoControl")
    }
    function SuperMannagercheckOut() {
        $.ajax({
            type: 'post',
            url: '/MainController/checkOut',
            data: {},
            success: function (data) {
                alert("您已退出登录")
               location.href="/LoginingController/"
            },
        }, JSON)
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
            <img  src="/CSS/MainCss/Image/gatamodified.jpg" style="width:100%;height: 30% "/>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column" >
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
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-195419"
                           href="#panel-element-280717">维修管理</a>
                    </div>
                    <div id="panel-element-280717" class="panel-collapse collapse"style="display: block">
                        <div class="panel-body" onclick="maintenanceControl()">
                            <a onclick="maintenanceControl()">维修表管理</a>
                        </div>
                        <div class="panel-body" onclick="maintenanceControl()"style="display: block">
                            <a onclick="maintenanceControl()">维修员管理</a>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a class="panel-title collapsed" data-toggle="collapse"style="display: block" data-parent="#panel-195419"
                           href="#panel-element-280722">信息管理</a>
                    </div>
                    <div id="panel-element-280722" class="panel-collapse collapse"style="display: block">
                        <div class="panel-body">
                            <a onclick="updateInfoControl()">信息管理</a>
                        </div>
                        <div class="panel-body" >
                            <a onclick="SuperMannagercheckOut()">退出登陆</a>
                        </div>
                    </div>
                </div>
            </div>
              <div class="col-md-9 column" >
                  <div id="repositoryControl" ></div>
              </div>
        </div>
    </div>
</div>
</body>
</html>