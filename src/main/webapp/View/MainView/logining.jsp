<%--
  Created by IntelliJ IDEA.
  User: 赵嗣瑜
  Date: 2017/5/11
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


    <!-- General meta information -->
    <title>Login Form by Oussama Afellad</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="robots" content="index, follow" />
    <meta charset="utf-8" />
    <!-- // General meta information -->


    <!-- Load Javascript -->
    <script type="text/javascript" src="/CSS/MainCss/xHTML/js/jquery.js"></script>
    <script type="text/javascript" src="/CSS/MainCss/xHTML/js/jquery.query-2.1.7.js"></script>
    <script type="text/javascript" src="/CSS/MainCss/xHTML/js/rainbows.js"></script>
    <!-- // Load Javascipt -->

    <!-- Load stylesheets -->
    <link type="text/css" rel="stylesheet" href="/CSS/MainCss/xHTML/css/style.css" media="screen" />
    <!-- // Load stylesheets -->

    <script>


        $(document).ready(function(){

            $("#submit1").hover(
                function() {
                    $(this).animate({"opacity": "0"}, "slow");
                },
                function() {
                    $(this).animate({"opacity": "1"}, "slow");
                });
        });

        function checkIn() {
            var username=$("#url").val();

            var password=$("input[name='password']").val()
            $.ajax({
                type:'post',
                url:'/LoginingController/checkIn',
                data:{username:username,password:password},
                success: function (data) {
                    var result = eval("(" + data + ")");
                    var status=result.loginCheck;
                    var userType=result.userType;
                    if(status=="true"){
                        if(userType=="学生"){
                            location.href="/MainController/"
                        }
                        if(userType=="宿舍管理员"){
                            location.href="/MainController/"
                        }
                        if(userType=="维修员"){
                            location.href="/MainController/"
                        }
                    }
                    else if(status=="false"){
                        alert("账号或密码错误")
                    }
                },
            },JSON)
        }
        function register() {
            var iWidth=720;                          //弹出窗口的宽度;
            var iHeight=600;                         //弹出窗口的高度;
            //获得窗口的垂直位置
            var iTop = (window.screen.availHeight - 30 - iHeight) / 2;
            //获得窗口的水平位置
            var iLeft = (window.screen.availWidth - 10 - iWidth) / 2;
            window.open('/LoginingController/register', '注册', 'height=' + iHeight + ',,innerHeight=' + iHeight + ',width=' + iWidth + ',innerWidth=' + iWidth + ',top=' + iTop + ',left=' + iLeft + ',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no');
        }
        function codeChange() {
            var iWidth=720;                          //弹出窗口的宽度;
            var iHeight=600;                         //弹出窗口的高度;
            //获得窗口的垂直位置
            var iTop = (window.screen.availHeight - 30 - iHeight) / 2;
            //获得窗口的水平位置
            var iLeft = (window.screen.availWidth - 10 - iWidth) / 2;
            window.open('/LoginingController/codeChange', '修改密码', 'height=' + iHeight + ',,innerHeight=' + iHeight + ',width=' + iWidth + ',innerWidth=' + iWidth + ',top=' + iTop + ',left=' + iLeft + ',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no');
        }
    </script>

</head>
<body>
<style>body {
    background-color: #d9edf7;
}</style>
<div id="wrapper">
    <div id="wrappertop"></div>

    <div id="wrappermiddle">

        <h2>宿舍管理登陆</h2>

        <div id="username_input">

            <div id="username_inputleft"></div>

            <div id="username_inputmiddle">
                <form action="/LoginingController/checkIn">
                    <input type="text" name="username" id="url" value="用户名" onclick="this.value = ''">
                    <img id="url_user" src="/CSS/MainCss/xHTML/images/mailicon.png" alt="">
                </form>
            </div>

            <div id="username_inputright"></div>

        </div>

        <div id="password_input">

            <div id="password_inputleft"></div>

            <div id="password_inputmiddle">
                <form action="/LoginingController/checkIn">
                    <input type="password" name="password" id="url" value="Password" onclick="this.value = ''">
                    <img id="url_password" src="/CSS/MainCss/xHTML/images/passicon.png" alt="">
                </form>
            </div>

            <div id="password_inputright"></div>

        </div>

        <div id="submit">
            <button type="submit"  onclick="checkIn()">登陆</button>
        </div>


        <div id="links_left">

            <a href="#" onclick="codeChange()">忘记密码？</a>

        </div>

        <div id="links_right"><a href="#" onclick="register()">注册</a></div>

    </div>

    <div id="wrapperbottom"></div>

    <div id="powered">
        <p>Powered by <a href="http://www.premiumfreebies.eu">Premiumfreebies Control Panel</a></p>
    </div>
</div>

</body>
</html>