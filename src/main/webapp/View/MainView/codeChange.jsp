<%--
  Created by IntelliJ IDEA.
  User: 赵嗣瑜
  Date: 2017/5/12
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>codeChange</title>
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js"></script>

    <script src="/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

</head>
<script>
    var checkNumber=0;
    function closeWindow() {
        window.close();
    }
    function registerSubmit() {
        var registerPassword=$("#registerPassword").val();
        var registerUsername=$("#registerUsername").val();
        var registerPasswordCheck=$("#registerPasswordCheck").val();
        var checkCode=$("#checkCode").val();
        if(registerPassword!=""&&registerUsername!=""&&registerPasswordCheck!=""&&checkCode!=""&&checkNumber==0){
            $.ajax({
                type:'post',
                url:'/LoginingController/codeChangeSubmit',
                data:{registerUsername:registerUsername,registerPassword:registerPassword,checkCode:checkCode},
                success: function (data) {
                    var result = eval("(" + data + ")");
                    var status=result.registerCheck;
                    if(status=="true"){
                        alert("修改成功")
                        window.close();
                    }
                    else if(status=="false"){
                        alert("请输入正确的激活码")
                    }
                },
            },JSON)
        }
        else {
            alert("请完善信息")
        }
    }
    $(document).ready (function registerCheck() {
        $("#registerUsername").focus(function checkResult() {
            document.getElementById("registerUsername").value="";
            $("#checkResult").empty();
        })
        $("#registerUsername").blur(function checkResult() {
            var username=$("#registerUsername").val();
            if(username!="") {
                $.ajax({
                    type: 'post',
                    url: '/LoginingController/usernameCheck',
                    data: {username: username},
                    success: function (data) {
                        var result = eval("(" + data + ")");
                        var usernameCheck = result.usernameCheck;
                        if (usernameCheck == "false") {
                            $("#checkResult").empty()
                            $("#checkResult").append("<font color='green'><p id='checkCor1'>无效的用户名</p></font>")
                            checkNumber=1;
                        }
                        else {
                            $("#checkResult").empty()
                            $("#checkResult").append("<font color='red'><p></p></font>")
                            checkNumber=0;
                        }
                    },
                }, JSON)
            }
            else {
                $("#checkResult").empty()
                $("#checkResult").append("<font color='red'><p>用户名不能为空</p></font>")
                checkNumber=1;
            }
        })
        $("#registerPasswordCheck").focus(function test(){
            document.getElementById("registerPasswordCheck").value="";
            $("#passwordCheckResult").empty();
        })
        $("#registerPassword").focus(function test(){
            document.getElementById("registerPassword").value="";
            $("#registerPasswordNull").empty();
            $("#passwordCheckResult").empty();
        })
        $("#registerPassword").blur(function test(){
            var registerPassword=$("#registerPassword").val()
            if(registerPassword==""){
                $("#registerPasswordNull").append("<font color='red'><p>密码不能为空</p></font>")
                checkNumber=1;

            }
        })

        $("#registerPasswordCheck").blur(function test(){
            var registerPassword=$("#registerPassword").val();
            var registerPasswordCheck=$("#registerPasswordCheck").val();
            if(registerPasswordCheck!="") {
                if (registerPassword == registerPasswordCheck) {
                    $("#passwordCheckResult").empty();
                    $("#passwordCheckResult").append("<font color='green'><p id='checkCore2'>可以使用的密码</p></font>")
                    checkNumber=0;
                }
                else {
                    $("#passwordCheckResult").empty();
                    $("#passwordCheckResult").append("<font color='red'><p>两次输入的密码不一致</p></font>")
                    checkNumber=1;

                }
            }
            else {
                $("#passwordCheckResult").empty();
                $("#passwordCheckResult").append("<font color='red'><p>密码不能为空</p></font>")
                checkNumber=1;
            }
        })
    })
</script>
<body>
<style>
    body{
        background-color: #d9edf7;
        margin: 0px auto;
    }
</style>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form">
                <div class="form-group">
                    <label for="registerUsername">用户名</label><input type="email" class="form-control" id="registerUsername" style="width: 20%"/><div id="checkResult"></div>
                </div>
                <div class="form-group">
                    <label for="registerPassword">新密码</label><input type="password" class="form-control" id="registerPassword" style="width: 20%"/><div id="registerPasswordNull"></div>
                </div>
                <div class="form-group">
                    <label for="registerPasswordCheck">请再次输入密码</label><input type="password" class="form-control" id="registerPasswordCheck" style="width: 20%"/><div id="passwordCheckResult"></div>
                </div>
                <div class="form-group">
                    <label for="checkCode">请输入激活码</label><input type="password" class="form-control" id="checkCode" style="width: 20%"/>
                </div>
                <button type="submit" class="btn btn-default" onclick="registerSubmit()">提交</button>
                <button onclick="closeWindow()" class="btn btn-default">关闭</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
