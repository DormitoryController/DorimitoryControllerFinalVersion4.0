<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/8
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>

    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

    <title>Insert title here</title>
</head>
<!--测试过i-->
<script>
    function Stu_newform(){
        $("#StudentrepositoryControl").load("/View/StudentView/Stu_newform.jsp")
    }
    function Stu_seerepairform(){
        $("#StudentrepositoryControl").load("/View/StudentView/Stu_seerepairform.jsp")

    }
    function Stu_reform(){
        $("#StudentrepositoryControl").load("/View/StudentView/Stu_reform.jsp")
    }
    function Stu_reformlist(){
        $("#StudentrepositoryControl").load("/View/StudentView/Stu_reformlist.jsp")

    }
    function Stu_perInf(){
        $("#StudentrepositoryControl").load("/View/StudentView/Stu_persion.jsp")
    }
    function Stu_UperInf(){
        $("#StudentrepositoryControl").load("/View/StudentView/Stu_persionUp.jsp")
    }
    function Stu_exit(){
        alert("退出成功！请重新登录！")
        $.ajax({
            type:'post',
            url:'/StudentView/checkOut',
            dataType: "json",
            data:{},
            success: function (data) {
                    location.href="/View/MainView/logining.jsp"
            },

        },JSON)
    }
</script>

<style>body {
    background-color: #d9edf7;
}
</style>
</head>

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
                                宿舍管理系统
                            </h4>
                            <p>
                               这是顶部
                            </p>
                        </div>
                    </div>
                    <div class="item">
                        <img alt="" src="/CSS/MainCss/Image/xiaohui.jpg" />
                        <div class="carousel-caption">
                            <h4>
                                宿舍管理系统
                            </h4>
                            <p>
                                页面二
                            </p>
                        </div>
                    </div>
                    <div class="item">
                        <img alt="" src="/CSS/MainCss/Image/xiaohui.jpg" />
                        <div class="carousel-caption">
                            <h4>
                                宿舍管理系统
                            </h4>
                            <p>
                                页面3
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
                        <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-195418" href="#panel-element-280715">报修管理</a>
                    </div>
                    <div id="panel-element-280715" class="panel-collapse collapse">
                        <div class="panel-body" onclick="Stu_newform()">
                            <a  onclick="Stu_newform()">新建维修表 </a>
                        </div>
                        <div class="panel-body" onclick="Stu_seerepairform()" aria-valuetext="/Stu_seeStatus">
                            <a  onclick="Stu_seerepairform()">查看进度 </a>
                        </div>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-195418" href="#panel-element-280714">维修信息</a>
                    </div>
                    <div id="panel-element-280714" class="panel-collapse collapse">
                        <div class="panel-body" onclick="Stu_reform()">
                            <a  onclick="Stu_reform()">评价回执 </a>
                        </div>
                        <div class="panel-body" onclick="Stu_reformlist()">
                            <a  onclick="Stu_reformlist()">查看回执单 </a>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-195418" href="#panel-element-280713">个人设置</a>
                    </div>
                    <div id="panel-element-280713" class="panel-collapse collapse">
                        <div class="panel-body" onclick="Stu_perInf()">
                            <a  onclick="Stu_perInf()">个人信息 </a>
                        </div>
                        <div class="panel-body" onclick="Stu_UperInf()">
                            <a  onclick="Stu_UperInf()">信息更新 </a>
                        </div>
                        <div class="panel-body" onclick="Stu_exit()">
                            <a  onclick="Stu_exit()">退出登录 </a>
                        </div>
                    </div>
                </div>
            </div>
              <div class="col-md-6 column">
                  <div id="StudentrepositoryControl" >
                  </div>
              </div>
        </div>
    </div>
</div>
</body>
</html>