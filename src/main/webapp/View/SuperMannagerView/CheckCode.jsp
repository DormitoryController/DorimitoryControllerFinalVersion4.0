
<%--
  Created by IntelliJ IDEA.
  User: 庞博
  Date: 2017/4/25
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
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
    function addstucode() {
        var student = $("#student").val();
        var repairer = $("#repairer").val();
        var supervisor = $("#supervisor").val();
            $.ajax({
                type: 'post',
                url: '/SuperMannagerController/CheckCodeItem',
                dataType: "json",
                data: {Student: student ,Repaier:repairer ,Supervisor:supervisor},
                success: function (data) {
                    alert("添加失败！")
                },
                error: function () {
                   alert("添加成功！")
                }
            }, JSON)
    }



</script>



<body>
   <form class="navbar-form pull-left">

       <input type="text" class="span2" id="student">请输入增加的学生数量</input>
       <br>
       </br>
       <input type="text" class="span2" id="repairer">请输入增加的维修人员数量</input>
       <br>
       </br>
       <input type="text" class="span2" id="supervisor">请输入增加的宿管人员数量</input>
       <br>
       </br>
       <button button1 onclick= 'addstucode()'>提交</button>

   </form>

</body>



</html>
